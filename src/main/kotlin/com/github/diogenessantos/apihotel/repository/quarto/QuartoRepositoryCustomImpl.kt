package com.github.diogenessantos.apihotel.repository.quarto

import com.github.diogenessantos.apihotel.model.Hotel
import com.github.diogenessantos.apihotel.model.Quarto
import jakarta.persistence.EntityManager
import jakarta.persistence.Query
import jakarta.persistence.TypedQuery
import jakarta.persistence.criteria.CriteriaQuery
import jakarta.persistence.criteria.Root
import java.lang.reflect.Type

class QuartoRepositoryCustomImpl (val entityManage: EntityManager) : QuartoRepositoryCustom {

    override fun buscarTodosPorIdHotel(idHotel: Long): List<Quarto> {
        val builder = entityManage.criteriaBuilder
        val queryQuarto : CriteriaQuery<Quarto>   = builder.createQuery(Quarto::class.java)
        val root : Root<Quarto> = queryQuarto.from(Quarto::class.java)

        queryQuarto.select(root)
        queryQuarto.where(builder.equal(root.get<Hotel>("idHotel").get<Long>("id") , idHotel))

        val typedQuery : TypedQuery<Quarto> = entityManage.createQuery(queryQuarto)
        val listaQuarto : List<Quarto> = typedQuery.resultList

        return listaQuarto

    }
}