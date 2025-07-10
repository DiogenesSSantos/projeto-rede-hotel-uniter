package com.github.diogenessantos.apihotel.repository

import com.github.diogenessantos.apihotel.model.Hotel
import org.springframework.data.jpa.repository.JpaRepository

interface HotelRepository: JpaRepository<Hotel , Long> {



}