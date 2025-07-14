package com.github.diogenessantos.apihotel.service

import com.github.diogenessantos.apihotel.repository.hotel.HotelRepository
import org.springframework.stereotype.Service


@Service
class HotelService (val repository: HotelRepository) {
}