package com.github.diogenessantos.apihotel.controller

import com.github.diogenessantos.apihotel.build.assembler.FuncionarioAssembler
import com.github.diogenessantos.apihotel.openapi.documentationfuncionario.FuncionarioDocumentationOpenAPI
import com.github.diogenessantos.apihotel.repository.funcionario.FuncionarioRepository
import org.springframework.data.domain.Pageable
import org.springframework.data.web.PageableDefault
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController


/**
 * Controlador REST para gerenciar recursos de Funcionário.
 *
 * @author DiógenesSantos
 * @version 1.0
 */
@RestController
@RequestMapping(path = ["/funcionario"])
class FuncionarioController(
    val funcionarioRepository: FuncionarioRepository,
    val funcionarioAssembler: FuncionarioAssembler
) :
    FuncionarioDocumentationOpenAPI() {


    @GetMapping
    override fun buscarTodos(@PageableDefault(page = 0, size = 5) pageable: Pageable): ResponseEntity<Any>? {
        val funcionarioDTOS = funcionarioRepository.findAll(pageable).map { FuncionarioAssembler.toDto(it) }
        return ResponseEntity.ok(funcionarioDTOS)

    }


    @GetMapping("/buscarpornome")
    fun buscarPorNome(
        @RequestParam("nome") nome: String,
        @PageableDefault(page = 0, size = 5) pageable: Pageable
    ): ResponseEntity<Any>? {

        val funcionarioDTOS = funcionarioRepository.buscarPorNome(nome , pageable).map { FuncionarioAssembler.toDto(it) }
        return ResponseEntity.ok(funcionarioDTOS)

    }


}