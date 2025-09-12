package com.github.diogenessantos.apihotel.controller.request

import com.github.diogenessantos.apihotel.model.Contato
import com.github.diogenessantos.apihotel.model.Endereco

data class FuncionarioRequestParcial (
    val nome: String? = null,
    val login: String? = null,
    val senha: String? = null,
    val contato: Contato? = null,
    val endereco: Endereco? = null,
)