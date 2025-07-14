package com.github.diogenessantos.apihotel.controller

import com.github.diogenessantos.apihotel.repository.pagamento.PagamentoRepository
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/pagamento")
class PagamentoController(val repository : PagamentoRepository) {





    @GetMapping
    fun buscarTodosPagamentos() : ResponseEntity<Any> {
        return  ResponseEntity.ok(repository.findAll())
    }


}