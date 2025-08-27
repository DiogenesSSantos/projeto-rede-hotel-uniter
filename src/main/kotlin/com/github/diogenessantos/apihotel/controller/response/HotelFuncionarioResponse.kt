package com.github.diogenessantos.apihotel.controller.response

import com.github.diogenessantos.apihotel.model.Funcionario

data class HotelFuncionarioResponse(
    val nome : String,
    val listaFuncionarios : List<Funcionario>
)
