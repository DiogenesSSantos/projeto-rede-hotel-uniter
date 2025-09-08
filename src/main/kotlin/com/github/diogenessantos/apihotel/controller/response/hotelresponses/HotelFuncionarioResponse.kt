package com.github.diogenessantos.apihotel.controller.response.hotelresponses

import com.fasterxml.jackson.annotation.JsonProperty
import com.github.diogenessantos.apihotel.controller.response.funcionariosresponses.FuncionarioResponse

data class HotelFuncionarioResponse(
    @JsonProperty(value = "Hotel")
    val nome : String,
    val listaFuncionarios : List<FuncionarioResponse>
)