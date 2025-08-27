package com.github.diogenessantos.apihotel.repository.hotel

import com.github.diogenessantos.apihotel.model.Funcionario
import com.github.diogenessantos.apihotel.model.Hotel
import jakarta.persistence.EntityManager
import jakarta.persistence.TypedQuery
import org.springframework.stereotype.Repository


@Repository
class HotelRepositoryCustomImpl(private  val entityManager: EntityManager) : HotelRepositoryCustom {

    override fun buscarFuncionariosHotel(id : Long): List<Funcionario> {
        val builder = entityManager.criteriaBuilder
        val query = builder.createQuery(Funcionario::class.java)
        val root = query.from(Funcionario::class.java)



        query.select(root)
        query.where(builder.equal(root.get<Hotel>("idHotel").get<Long>("id"), id))

        val typedQuery : TypedQuery<Funcionario> = entityManager.createQuery(query)
        val listaFuncionario : List<Funcionario> = typedQuery.resultList

        return listaFuncionario

    }


}