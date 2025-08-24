package com.github.diogenessantos.apihotel.controller.response

import com.github.diogenessantos.apihotel.model.Contato
import com.github.diogenessantos.apihotel.model.Endereco

data class FuncionarioResponse (
    val cpf: Long?,
    val nome: String?,
    val contato: Contato?,
    val endereco: Endereco?,
) {
}