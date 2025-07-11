package com.github.diogenessantos.apihotel.repository

import com.github.diogenessantos.apihotel.model.Funcionario
import org.springframework.data.jpa.repository.JpaRepository

interface FuncionarioRepository : JpaRepository<Funcionario , Long> , TesteImportando {
}