package com.github.diogenessantos.apihotel.controller

import com.github.diogenessantos.apihotel.repository.FuncionarioRepository
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping(path = ["/funcionario"])
class FuncionarioController(val funcionarioRepository: FuncionarioRepository) {



    @GetMapping
    fun buscarTodos() : ResponseEntity<Any>? {
        return ResponseEntity.ok(funcionarioRepository.findAll())

    }


}