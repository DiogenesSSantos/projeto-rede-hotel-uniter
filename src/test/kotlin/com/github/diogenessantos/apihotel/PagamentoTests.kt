package com.github.diogenessantos.apihotel

import com.github.diogenessantos.apihotel.model.Pagamento
import com.github.diogenessantos.apihotel.model.StatusPagamento
import jakarta.persistence.EntityManager
import jakarta.persistence.Tuple
import jakarta.persistence.TypedQuery
import jakarta.persistence.criteria.CriteriaBuilder
import jakarta.persistence.criteria.CriteriaQuery
import jakarta.persistence.criteria.Root
import jakarta.transaction.Transactional
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase
import org.springframework.boot.test.context.SpringBootTest
import java.math.BigDecimal
import java.math.BigInteger

@SpringBootTest
class PagamentoTests {

    @Autowired
    lateinit var entityManager: EntityManager




    @Transactional
    @Test
    fun buscar_todos_pagamentos_maiorq_happypath() {
        val builder : CriteriaBuilder = entityManager.criteriaBuilder
        val query : CriteriaQuery<Pagamento> = builder.createQuery(Pagamento::class.java)
        val root : Root<Pagamento> = query.from(Pagamento::class.java)
        root

        query.select(root)
        query.where(builder.greaterThanOrEqualTo(root.get<BigDecimal>("valor") ,
            BigDecimal("10")))

        val typeQuery : TypedQuery<Pagamento> = entityManager.createQuery(query)
        val listPagamento : List<Pagamento> = typeQuery.resultList

        
        listPagamento.forEach { pag -> println("VALOR PAGO -> ${pag.valor} ") }
    }


    @Transactional
    @Test
    fun buscarTodos_statusPamento_groupBY() {
        val builder : CriteriaBuilder = entityManager.criteriaBuilder
        val query : CriteriaQuery<Tuple> = builder.createTupleQuery()
        val root : Root<Pagamento> = query.from(Pagamento::class.java)

        query.multiselect(root.get<StatusPagamento>("status") ,
            builder.sum(root.get<BigDecimal>("valor")),
            builder.avg(root.get<BigDecimal>("valor")))

        query.groupBy(root.get<StatusPagamento>("status"))


        val type : TypedQuery<Tuple> = entityManager.createQuery(query)
        val list : List<Tuple> = type.resultList


        list.forEach { tuple ->
            println("TIPO DE STATUS: ${tuple.get(0)} || VALOR POR STATUS: ${tuple.get(1)} || MEDIA : ${tuple.get(2)}")


        }

    }


    @Test
    fun buscarTodos () {
        val builder : CriteriaBuilder = entityManager.criteriaBuilder
        val query = builder.createQuery(Pagamento::class.java)
        val root = query.from(Pagamento::class.java)

        query.select(root)


        entityManager.createQuery(query).resultList.forEach { println(it.valor)}



    }



}