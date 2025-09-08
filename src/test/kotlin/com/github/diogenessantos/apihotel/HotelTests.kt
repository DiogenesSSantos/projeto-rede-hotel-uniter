package com.github.diogenessantos.apihotel

import com.github.diogenessantos.apihotel.model.Funcionario
import com.github.diogenessantos.apihotel.model.Hotel
import com.github.diogenessantos.apihotel.service.HotelService
import jakarta.persistence.EntityManager
import jakarta.persistence.TypedQuery
import jakarta.persistence.criteria.CriteriaBuilder
import jakarta.persistence.criteria.CriteriaQuery
import jakarta.persistence.criteria.Root
import jakarta.persistence.criteria.Subquery
import org.hibernate.query.Query
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import kotlin.test.assertFalse
import kotlin.test.assertNotNull


@SpringBootTest
class HotelTests {

    @Autowired
    lateinit var entityManager: EntityManager

    @Autowired
    lateinit var hotelService: HotelService


    @Test
    fun retornar_todos_hoteis () {
        val criteriaBuilder : CriteriaBuilder = entityManager.criteriaBuilder
        val hotelQuery  : CriteriaQuery<Hotel> = criteriaBuilder.createQuery(Hotel::class.java)
        val hotelRoot : Root<Hotel> = hotelQuery.from(Hotel::class.java)

        hotelQuery.select(hotelRoot)


        val typedQuery : TypedQuery<Hotel> = entityManager.createQuery(hotelQuery)
        val listHotel : List<Hotel> = typedQuery.resultList

        println(listHotel)

    }




    @Test
    fun buscar_todos_funcionario_hotel_happyPath_CriteriaBuilde() {
        val builder : CriteriaBuilder = entityManager.criteriaBuilder
        val hotelquery : CriteriaQuery<Hotel>  = builder.createQuery(Hotel::class.java)
        val hotelRoot : Root<Hotel>  = hotelquery.from(Hotel::class.java)


        val FuncionariosubQuery : Subquery<Funcionario> = hotelquery.subquery(Funcionario::class.java)
        val funcionarioRoot : Root<Funcionario>  = FuncionariosubQuery.from(Funcionario::class.java)
        FuncionariosubQuery.select(funcionarioRoot)
            .where(builder.equal(funcionarioRoot.get<Hotel>("idHotel") , hotelRoot ))


        hotelquery.select(hotelRoot)
            .where(builder.exists(FuncionariosubQuery))



        val typedQuery : TypedQuery<Hotel> = entityManager.createQuery(hotelquery)


        println(typedQuery.resultList)



    }


//    @Test
//    fun buscar_quarto_por_id_Hotel_happyPath() {
//        val id : Long = 1
//        val hotel =hotelService.buscarPorId(id)
//        val listaQuartoPorIdHotel =  hotelService.buscarTodosQuartos(hotel)
//
//
//        assertNotNull(listaQuartoPorIdHotel)
//        assertFalse(listaQuartoPorIdHotel.isEmpty())
//
//    }




}