package com.github.diogenessantos.apihotel.controller.response.quartoresponses

import com.github.diogenessantos.apihotel.model.StatusQuarto

data class QuartoResponse(
    val quantidadeLeitos: Int,
    val tipo: String,
    val status: StatusQuarto,
    val nomeHotel : String
)