package com.github.diogenessantos.apihotel.repository.funcionario

import com.github.diogenessantos.apihotel.model.Funcionario
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface FuncionarioRepository : JpaRepository<Funcionario, Long>, FuncionarioRepositoryCustom {
}