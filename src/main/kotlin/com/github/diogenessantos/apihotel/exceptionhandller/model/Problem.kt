package com.github.diogenessantos.apihotel.exceptionhandller.model

import com.fasterxml.jackson.annotation.JsonFormat
import java.time.LocalDateTime


data class Problem(
    val status: Int,
    val type: String,
    val title: String,
    val details: LocalDateTime?,
    val instance: String,
    @JsonFormat(pattern = "dd-MM-yyyy'T' HH:mm:ss")
    val timestamp: LocalDateTime = LocalDateTime.now(),

    )
