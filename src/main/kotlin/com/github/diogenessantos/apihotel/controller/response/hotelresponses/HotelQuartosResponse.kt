package com.github.diogenessantos.apihotel.controller.response.hotelresponses

import com.github.diogenessantos.apihotel.model.Quarto

data class HotelQuartosResponse(val nome : String, val listaQuartos : List<Quarto>)
