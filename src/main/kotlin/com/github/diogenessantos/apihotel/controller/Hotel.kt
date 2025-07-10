package com.github.diogenessantos.apihotel.controller

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping(path = ["/hotel"])
class Hotel {



    @GetMapping
    fun teste() : ResponseEntity<Any> {
        return ResponseEntity.status(HttpStatus.OK)
            .body("FUNCIONANDO")
    }


}