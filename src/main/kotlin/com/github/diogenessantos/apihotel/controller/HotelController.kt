package com.github.diogenessantos.apihotel.controller

import com.github.diogenessantos.apihotel.build.assembler.HotelAssembler
import com.github.diogenessantos.apihotel.controller.response.HotelResponse
import com.github.diogenessantos.apihotel.service.HotelService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
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
class HotelController (val service: HotelService, val hotelAssembler: HotelAssembler) {
    


    @GetMapping
    fun buscarTodos(): ResponseEntity<List<HotelResponse>> {
       val hoteis = service.buscarTodos()
       val hoteisResponse = hoteis.map { hotelAssembler.toResponse(it) }

        return ResponseEntity.status(HttpStatus.OK).body(hoteisResponse)
    }

    @GetMapping("/{id}")
    fun buscarPorId(@PathVariable(name = "id") id : Long) : ResponseEntity<HotelResponse> {
        val hotel = service.buscarPorId(id)
        val hotelResponse = hotel.run { hotelAssembler.toResponse(this) }
        return ResponseEntity.status(HttpStatus.OK).body(hotelResponse)
    }



}