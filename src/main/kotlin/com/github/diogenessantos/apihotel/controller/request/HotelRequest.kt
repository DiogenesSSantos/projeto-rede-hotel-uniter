package com.github.diogenessantos.apihotel.controller.request

import com.github.diogenessantos.apihotel.model.Contato
import com.github.diogenessantos.apihotel.model.Endereco
import jakarta.persistence.Embedded

data class HotelRequest(
    var nome: String,
    var categoria: String,
    var contato: Contato,
    var endereco: Endereco
) {

}
