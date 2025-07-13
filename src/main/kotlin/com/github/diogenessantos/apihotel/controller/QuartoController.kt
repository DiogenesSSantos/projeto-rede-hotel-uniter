package com.github.diogenessantos.apihotel.controller

import com.github.diogenessantos.apihotel.model.Quarto
import com.github.diogenessantos.apihotel.repository.quarto.quartoRepository
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/quarto")
class QuartoController (val repository: quartoRepository) {



    @GetMapping
    fun buscarTodosQuartos() : ResponseEntity<Any> {
        var buscarOuFalhar = repository.findAll();

        buscarOuFalhar?.let {

            return ResponseEntity.ok(buscarOuFalhar)
        }
        return ResponseEntity.noContent().build()
    }


}