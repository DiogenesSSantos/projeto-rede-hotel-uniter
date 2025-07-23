package com.github.diogenessantos.apihotel.repository.funcionario

import com.github.diogenessantos.apihotel.model.Funcionario
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Repository

@Repository
interface FuncionarioRepositoryCustom {

    fun buscarPorNome (nome : String , pageable: Pageable) : Page<Funcionario>

}