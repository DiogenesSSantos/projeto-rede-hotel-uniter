package com.github.diogenessantos.apihotel.controller.response.quartoresponses

data class QuartoRequest(
    var quantidadeLeitos: Int? = null,
    var tipo: String?           = null,
    var senha: Int?            = null,
    var idHotel: Long?          = null
)

