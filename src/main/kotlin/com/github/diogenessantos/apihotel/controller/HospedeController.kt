package com.github.diogenessantos.apihotel.controller

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping ("/hospede")
class HospedeController  {



    @GetMapping
    fun buscarTodos() : ResponseEntity<Any> {

        return ResponseEntity.ok().build()

    }


}