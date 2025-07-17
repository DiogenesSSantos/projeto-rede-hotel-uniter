package com.github.diogenessantos.apihotel.model.dtos.hotelDTO

import com.github.diogenessantos.apihotel.model.Endereco

data class HotelDTO(
    val nome: String?,
    val categoria: String?,
    val endereco: Endereco?
    )