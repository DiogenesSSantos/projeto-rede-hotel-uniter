package com.github.diogenessantos.apihotel.controller.request

import com.github.diogenessantos.apihotel.model.Contato
import com.github.diogenessantos.apihotel.model.Endereco

data class HotelResquetFiltro(
    var nome: String? = null,
    var categoria: String? = null,
    var contato: Contato? = null,
    var endereco: Endereco? = null
){}
