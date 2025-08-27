package com.github.diogenessantos.apihotel.controller.response

import com.fasterxml.jackson.annotation.JsonAlias
import com.fasterxml.jackson.annotation.JsonFormat
import com.fasterxml.jackson.annotation.JsonProperty
import com.github.diogenessantos.apihotel.model.Funcionario

data class HotelFuncionarioResponse(
    @JsonProperty(value = "Hotel")
    val nome : String,
    val listaFuncionarios : List<FuncionarioResponse>
)
