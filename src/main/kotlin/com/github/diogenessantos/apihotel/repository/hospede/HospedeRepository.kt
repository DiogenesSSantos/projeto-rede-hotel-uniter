package com.github.diogenessantos.apihotel.repository.hospede

import com.github.diogenessantos.apihotel.model.Hospede
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository




@Repository
interface HospedeRepository : JpaRepository<Hospede , Long> {
}