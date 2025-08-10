package com.github.diogenessantos.apihotel.repository.funcionario

import com.github.diogenessantos.apihotel.exceptionhandller.exceptionfuncionario.CPFinvalidoException
import com.github.diogenessantos.apihotel.exceptionhandller.exceptionfuncionario.FuncionarioNaoExisteException
import com.github.diogenessantos.apihotel.model.Funcionario
import jakarta.persistence.EntityManager
import jakarta.persistence.NoResultException
import jakarta.persistence.TypedQuery
import jakarta.persistence.criteria.CriteriaBuilder
import jakarta.persistence.criteria.CriteriaQuery
import jakarta.persistence.criteria.Root
import jakarta.transaction.Transactional
import org.springframework.data.domain.Page
import org.springframework.data.domain.PageImpl
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Repository


@Repository
class FuncionarioRepositoryCustomImpl(val entityManage: EntityManager) : FuncionarioRepositoryCustom {


    override fun buscarPorNome(nome: String, pageable: Pageable): Page<Funcionario> {
        val builder: CriteriaBuilder = entityManage.criteriaBuilder

        val criteriaQuery: CriteriaQuery<Funcionario> = builder.createQuery(Funcionario::class.java)
        val root: Root<Funcionario> = criteriaQuery.from(Funcionario::class.java)
        criteriaQuery.select(root)

        if (nome.isNotBlank()) {
            criteriaQuery.where(builder.like(root.get<String>("nome"), "$nome%"))
        }

        val query = entityManage.createQuery(criteriaQuery)
            .apply {
                firstResult = pageable.offset.toInt()
                maxResults = pageable.pageSize
            }

        val lista: List<Funcionario> = query.resultList


        val countCq: CriteriaQuery<Long> = builder.createQuery(Long::class.java)
        val countRoot: Root<Funcionario> = countCq.from(Funcionario::class.java)
        countCq.select(builder.count(countRoot))

        if (nome.isNotBlank()) {
            countCq.where(builder.like(countRoot.get<String>("nome"), "$nome%"))
        }

        val total: Long = entityManage
            .createQuery(countCq)
            .singleResult

        return PageImpl(lista, pageable, total)
    }


    @Transactional
    override fun buscarPorCPF(cpf: Long): Funcionario {
        if (cpf == null) {
            throw CPFinvalidoException()
        }

        try {
            val criteriaBuilder: CriteriaBuilder = entityManage.criteriaBuilder
            val funcionarioQuery: CriteriaQuery<Funcionario> = criteriaBuilder.createQuery(Funcionario::class.java)
            val root: Root<Funcionario> = funcionarioQuery.from(Funcionario::class.java)

            funcionarioQuery.select(root)

            funcionarioQuery.where(criteriaBuilder.equal(root.get<Long>("CPF"), cpf))

            val typerQuery : TypedQuery<Funcionario> = entityManage.createQuery(funcionarioQuery)
            val funcionario : Funcionario = typerQuery.singleResult

            return funcionario
        } catch (ex : NoResultException) {
            throw FuncionarioNaoExisteException()
        }

    }


}