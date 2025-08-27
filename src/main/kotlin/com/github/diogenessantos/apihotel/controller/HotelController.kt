package com.github.diogenessantos.apihotel.controller

import com.github.diogenessantos.apihotel.build.assembler.HotelAssembler
import com.github.diogenessantos.apihotel.controller.request.HotelRequest
import com.github.diogenessantos.apihotel.controller.request.HotelResquetFiltro
import com.github.diogenessantos.apihotel.controller.response.FuncionarioResponse
import com.github.diogenessantos.apihotel.controller.response.HotelResponse
import com.github.diogenessantos.apihotel.service.HotelService
import org.apache.coyote.Response
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
class HotelController(val service: HotelService, val hotelAssembler: HotelAssembler) {


    @GetMapping
    fun buscarTodos(): ResponseEntity<List<HotelResponse>> {
        val hoteis = service.buscarTodos()
        val hoteisResponse = hoteis.map { hotelAssembler.toResponse(it) }

        return ResponseEntity.status(HttpStatus.OK).body(hoteisResponse)
    }

    @GetMapping("/{id}")
    fun buscarPorId(@PathVariable(name = "id") id: Long): ResponseEntity<HotelResponse> {
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
    fun atualizar(
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


    //Todo refatorá para receber como parâmetros buscarTodosFuncionarios o hotel direto implementar também o retorno
    // do funcionarioResponse sem dados desnecessário.
    @GetMapping("/{id}/funcionarios")
    fun buscarTodosFuncionarios(@PathVariable("id") id: Long): ResponseEntity<Any?>? {
        val hotel = service.buscarPorId(id)
        val todosFuncionariosHotel = service.buscarTodosFuncionarios(id)
        val hotelFuncionarioResponse = hotelAssembler.toHotelFuncionarioResponse(hotel, todosFuncionariosHotel)
        return ResponseEntity.status(HttpStatus.OK).body(hotelFuncionarioResponse)
    }


}