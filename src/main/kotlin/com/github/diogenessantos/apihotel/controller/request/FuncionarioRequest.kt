package com.github.diogenessantos.apihotel.controller.request

import com.github.diogenessantos.apihotel.model.Contato
import com.github.diogenessantos.apihotel.model.Endereco

data class FuncionarioRequest (
    val cpf: Long,
    val nome: String,
    val login: String,
    val senha: String,
    val contato: Contato,
    val endereco: Endereco,
    val idHotel: Long

)