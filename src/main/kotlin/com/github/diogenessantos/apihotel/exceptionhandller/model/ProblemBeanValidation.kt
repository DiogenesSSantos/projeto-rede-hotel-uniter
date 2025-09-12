package com.github.diogenessantos.apihotel.exceptionhandller.model

import java.time.LocalDateTime


data class ProblemBeanValidation(
    val status: Int,
    val type: String,
    val title: String,
    val details: LocalDateTime?,
    val instance: String,
    val camposInvalido: List<CampoInvalidoBeanValidation>
    )
