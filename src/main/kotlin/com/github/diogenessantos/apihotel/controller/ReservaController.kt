package com.github.diogenessantos.apihotel.controller

import com.github.diogenessantos.apihotel.repository.reserva.ReservaRepository
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping("/reserva")
class ReservaController (val repository: ReservaRepository){

    @GetMapping
    fun buscarTodos() : ResponseEntity<Any> {

        return ResponseEntity.ok(repository.findAll())
    }



}