package com.github.diogenessantos.apihotel.controller

import com.github.diogenessantos.apihotel.build.assembler.HotelAssembler
import com.github.diogenessantos.apihotel.controller.request.HotelRequest
import com.github.diogenessantos.apihotel.controller.request.HotelResquetFiltro
import com.github.diogenessantos.apihotel.controller.response.hotelresponses.HotelFuncionarioResponse
import com.github.diogenessantos.apihotel.controller.response.hotelresponses.HotelResponse
import com.github.diogenessantos.apihotel.openapi.documentationhotel.HotelDocumentationOpenAPI
import com.github.diogenessantos.apihotel.service.HotelService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PatchMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


/**
 * Controlador REST para gerenciar recursos de Funcionário.
 *
 * @author DiógenesSantos
 * @version 1.0
 */
@RestController
@RequestMapping(path = ["/hoteis"])
class HotelController(val service: HotelService, val hotelAssembler: HotelAssembler) : HotelDocumentationOpenAPI() {


    @GetMapping
    override fun buscarTodos(): ResponseEntity<List<HotelResponse>> {
        val hoteis = service.buscarTodos()
        val hoteisResponse = hoteis.map { hotelAssembler.toResponse(it) }

        return ResponseEntity.status(HttpStatus.OK).body(hoteisResponse)
    }

    @GetMapping("/{id}")
    override fun buscarPorId(@PathVariable(name = "id") id: Long): ResponseEntity<HotelResponse> {
        val hotel = service.buscarPorId(id)
        val hotelResponse = hotel.run { hotelAssembler.toResponse(this) }
        return ResponseEntity.status(HttpStatus.OK).body(hotelResponse)
    }


    @PostMapping
    fun salvar(@RequestBody hotelRequest: HotelRequest): ResponseEntity<HotelResponse> {
        var hotel = hotelAssembler.toObject(hotelRequest)
        hotel = service.salvar(hotel)
        val hotelResponse = hotelAssembler.toResponse(hotel)

        return ResponseEntity.status(HttpStatus.OK).body(hotelResponse)
    }


    @PutMapping("/{id}")
    override fun atualizar(
        @PathVariable("id") id: Long,
        @RequestBody hotelRequest: HotelRequest
    ): ResponseEntity<HotelResponse> {
        val hotel = service.atualizarPorCompleto(id, hotelRequest)
        val hotelResponse = hotelAssembler.toResponse(hotel)

        return ResponseEntity.status(HttpStatus.OK).body(hotelResponse)
    }


    @PatchMapping("/{id}")
    fun atualizarParcial(
        @PathVariable("id") id: Long, @RequestBody
        hotelResquetFiltro: HotelResquetFiltro
    ): ResponseEntity<HotelResponse> {

        val hotel = service.atualizarParcial(id, hotelResquetFiltro)
        val hotelResponse = hotelAssembler.toResponse(hotel)

        return ResponseEntity.status(HttpStatus.OK).body(hotelResponse)

    }


    @DeleteMapping("/{id}")
    fun excluir(@PathVariable("id") id: Long): ResponseEntity<Any?> {
        service.deletar(id)
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build()
    }



    @GetMapping("/{id}/funcionarios")
    fun buscarTodosFuncionarios(@PathVariable("id") id: Long): ResponseEntity<HotelFuncionarioResponse> {
        val hotel = service.buscarPorId(id)
        val todosFuncionarios = service.buscarTodosFuncionarios(hotel)
        val hotelFuncionarioResponse = hotelAssembler.toHotelFuncionarioResponse(hotel, todosFuncionarios)

        return ResponseEntity.status(HttpStatus.OK).body(hotelFuncionarioResponse)
    }

    @GetMapping("/{id}/quartos")
    fun buscarTodosQuartos(@PathVariable("id") id: Long): ResponseEntity<Any?>? {
        val hotel = service.buscarPorId(id)
        val todosQuartos = service.buscarTodosQuartos(hotel)
        val hotelQuartosResponse = hotelAssembler.toHotelQuartoResponse(hotel,todosQuartos)

        return ResponseEntity.status(HttpStatus.OK).body(hotelQuartosResponse)
    }



    // Todo refaratora classe reserva tem que ter id hotel para buscar todos os hospedes !
    @GetMapping("/{id}/hospedes")
    fun buscarTodosHospedes(@PathVariable("id") id: Long): ResponseEntity<Any?>? {
        val hotel = service.buscarPorId(id)
        return null
    }


}