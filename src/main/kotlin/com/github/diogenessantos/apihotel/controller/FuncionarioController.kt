package com.github.diogenessantos.apihotel.controller

import com.github.diogenessantos.apihotel.build.assembler.FuncionarioAssembler
import com.github.diogenessantos.apihotel.controller.request.FuncionarioRequest
import com.github.diogenessantos.apihotel.model.Funcionario
import com.github.diogenessantos.apihotel.model.dtos.funcionarioDTO.FuncionarioDTO
import com.github.diogenessantos.apihotel.openapi.documentationfuncionario.FuncionarioDocumentationOpenAPI
import com.github.diogenessantos.apihotel.service.FuncionarioService
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.web.PageableDefault
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PatchMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
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
    val funcionarioAssembler: FuncionarioAssembler,
    private val  funcionarioservice : FuncionarioService
) :
    FuncionarioDocumentationOpenAPI() {


    @GetMapping
    override fun buscarTodos(@PageableDefault(page = 0, size = 5) pageable: Pageable): ResponseEntity<Any>? {
        val funcionarioDTOS: Page<FuncionarioDTO?> = funcionarioservice.buscarTodos(pageable).map { funcionarioAssembler.toDto(it) }
        return ResponseEntity.ok(funcionarioDTOS)

    }


    @GetMapping("/buscarpornome")
    override  fun buscarPorNome(@RequestParam("nome") nome: String, @PageableDefault(page = 0, size = 5) pageable: Pageable): ResponseEntity<Any>? {

        val funcionarioDTOS = funcionarioservice.buscarPorNome(nome , pageable).map { funcionarioAssembler.toDto(it) }
        return ResponseEntity.ok(funcionarioDTOS)

    }


    @GetMapping("/buscarporcpf")
    fun buscarPorCpf(@RequestParam("cpf") cpf : Long) : ResponseEntity<Any?>? {
        val funcionarioLocalizado = funcionarioservice.buscarPorCPF(cpf)
        return ResponseEntity.ok().body(funcionarioLocalizado)
    }


    /**
     * @author
     * A Ideia desse end-point e trazer todos funcionários que trabalha no hotel x.
     */
    @GetMapping("/buscarporidhotel/{id}")
    fun buscarTodosPorIdHotel( @PathVariable("id") idHotel : Long) :  ResponseEntity<Any?>?{
        val listaFuncionariosHotel : List<Funcionario> = funcionarioservice.buscarFuncionarioPorIdHotel(idHotel)
        return ResponseEntity.ok().body(listaFuncionariosHotel)
    }


    @PutMapping
    fun atualizarCompleto(@RequestBody funcionarioRequest : FuncionarioRequest) : Funcionario {
        return funcionarioservice.atualizacaoCompleta(funcionarioAssembler.toModel(funcionarioRequest))

    }

    @PatchMapping
    fun atualizarParcial(@RequestBody funcionarioRequest: FuncionarioRequest) {

    }


    @PostMapping
    fun salvar(@RequestBody funcionario : FuncionarioRequest) : Funcionario {
        val funcionarioSalvo = funcionarioservice.salvar(funcionarioAssembler.toModel(funcionario))
        return funcionarioSalvo
    }


}