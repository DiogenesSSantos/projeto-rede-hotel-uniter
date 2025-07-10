package com.github.diogenessantos.apihotel.model

import jakarta.persistence.Enumerated
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id

class Quarto (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id : Long?,

    var quantidadeLeitos : Int,

    var tipo : String,

    @Enumerated
    var status : StatusQuarto = StatusQuarto.DISPONIVEL,

    var senha : Int,

    var idHotel: Hotel
) {
}