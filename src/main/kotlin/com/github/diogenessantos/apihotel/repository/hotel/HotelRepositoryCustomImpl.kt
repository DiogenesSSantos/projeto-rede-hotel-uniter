package com.github.diogenessantos.apihotel.repository.hotel

import com.github.diogenessantos.apihotel.model.Funcionario
import com.github.diogenessantos.apihotel.model.Hotel
import com.github.diogenessantos.apihotel.model.Quarto
import jakarta.persistence.EntityManager
import jakarta.persistence.TypedQuery
import org.springframework.stereotype.Repository


@Repository
class HotelRepositoryCustomImpl(private val entityManager: EntityManager) : HotelRepositoryCustom {

    override fun buscarFuncionarios(id: Long): List<Funcionario> {
        val builder = entityManager.criteriaBuilder
        val query = builder.createQuery(Funcionario::class.java)
        val root = query.from(Funcionario::class.java)



        query.select(root)
        query.where(builder.equal(root.get<Hotel>("idHotel").get<Long>("id"), id))

        val typedQuery: TypedQuery<Funcionario> = entityManager.createQuery(query)
        val listaFuncionario: List<Funcionario> = typedQuery.resultList

        return listaFuncionario

    }

    /**
     * @author diogenes
     * a idéia aqui e mais sobre prática o JPQL pura mesmo exemplos anteriores usamos CriteriaAPI.
     *
     */
    override fun buscarTodosQuartos(id: Long): List<Quarto> {

        val jpql: String = "SELECT q from Quarto q JOIN FETCH q.idHotel where q.idHotel.id = :id"
        val typedQuery: TypedQuery<Quarto> = entityManager.createQuery(jpql, Quarto::class.java)
        typedQuery.setParameter("id", id)
        val listaQuarto: List<Quarto> = typedQuery.resultList
        return listaQuarto

    }


}