package com.github.diogenessantos.apihotel.controller

import com.github.diogenessantos.apihotel.repository.hotel.HotelRepository
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController



/**
 * Controlador REST para gerenciar recursos de Funcionário.
 *
 * @author DiógenesSantos
 * @version 1.0
 */
@RestController
@RequestMapping(path = ["/hotel"])
class HotelController (val hotelRepository: HotelRepository) {
    
    
    

    @GetMapping
    fun teste() : ResponseEntity<Any> {
        return ResponseEntity.status(HttpStatus.OK)
            .body(hotelRepository.findAll())
    }


}