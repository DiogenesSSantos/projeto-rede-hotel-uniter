package com.github.diogenessantos.apihotel.controller.response

import com.github.diogenessantos.apihotel.model.Contato
import com.github.diogenessantos.apihotel.model.Endereco
import jakarta.persistence.Embedded

data class HotelResponse(
    val id: Long,
    val nome : String,
    val categoria : String,
    val contato: Contato,
    val endereco: Endereco

) {}

