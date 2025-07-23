package com.github.diogenessantos.apihotel.service

import com.github.diogenessantos.apihotel.exceptionhandller.exceptionfuncionario.FuncionarioNaoExisteException
import com.github.diogenessantos.apihotel.model.Funcionario
import com.github.diogenessantos.apihotel.repository.funcionario.FuncionarioRepository
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service
import kotlin.jvm.optionals.getOrElse


/**
 * @author
 * Classe service, aonde fica localizada a regra de negocio.
 */


@Service
class FuncionarioService (val repository: FuncionarioRepository) {





    fun buscarTodos() : MutableList<Funcionario> {
        return repository.findAll()
    }

    fun buscarPorNome( nome : String , pageable: Pageable ) : MutableList<Funcionario>  {
        val buscarPorNomePageable = repository.buscarPorNome(nome, pageable)
        return buscarPorNomePageable.toList()
    }


    fun buscarPorCPF (cpf : Long): Funcionario{
        val funcionario = repository.findByCPF(cpf)
        return funcionario.getOrElse { throw FuncionarioNaoExisteException() }
    }



}