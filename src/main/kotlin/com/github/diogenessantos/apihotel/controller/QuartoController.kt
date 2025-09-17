package com.github.diogenessantos.apihotel.controller

import com.github.diogenessantos.apihotel.build.assembler.QuartoAssembler
import com.github.diogenessantos.apihotel.controller.response.quartoresponses.QuartoRequest
import com.github.diogenessantos.apihotel.controller.response.quartoresponses.QuartoResponse
import com.github.diogenessantos.apihotel.exceptionhandller.exceptionhotel.HotelNaoLocalizadoException
import com.github.diogenessantos.apihotel.model.Hotel
import com.github.diogenessantos.apihotel.model.Quarto
import com.github.diogenessantos.apihotel.service.HotelService
import com.github.diogenessantos.apihotel.service.QuartoService
import io.swagger.v3.oas.annotations.parameters.RequestBody
import org.apache.coyote.Response
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


/**
 * Controlador REST para gerenciar recursos de Funcionário.
 *
 * @author DiógenesSantos
 * @version 1.0
 */
@RestController
@RequestMapping("/quartos")
class QuartoController(
    private val service: QuartoService,
    private val hotelService : HotelService,
    private val quartoAssembler: QuartoAssembler
) {


    @GetMapping
    fun buscarTodosQuartos(): ResponseEntity<List<QuartoResponse>> {
        var todosQuarto = service.buscarTodos()
        return ResponseEntity.ok().body(quartoAssembler.modelToListResponse(todosQuarto))
    }


    @PostMapping
    fun salvar(@RequestBody quartoRequest: QuartoRequest): ResponseEntity<QuartoResponse> {

        println(quartoRequest)
        var quarto: Quarto = quartoAssembler.requestToModel(quartoRequest)
        quarto = service.salvar(quarto)

        val quartoResponse: QuartoResponse = quartoAssembler.modelToResponse(quarto)

        return ResponseEntity.ok().body(quartoResponse)
    }


    @GetMapping("/hoteis/{id}")
    fun buscarQuartosDoHotelPorId(@PathVariable("id") id:Long): ResponseEntity<List<QuartoResponse>>? {
        hotelService.existe(id)
        val quartoHotel = service.buscarTodosPorIdHotel(id)
        val quartoHotelAssemblerList = quartoAssembler.modelToListResponse(quartoHotel)

        return ResponseEntity.ok().body(quartoHotelAssemblerList)
    }


}