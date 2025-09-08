package com.github.diogenessantos.apihotel.validator

import jakarta.validation.Constraint
import jakarta.validation.Payload
import kotlin.reflect.KClass


@Target(AnnotationTarget.FIELD)
@Retention(AnnotationRetention.RUNTIME)
@MustBeDocumented
@Constraint(validatedBy = [ValidadorMenorIdade::class])
annotation class MenorDeIdade(
    /**
     * Mensagem de erro padrão.
     */
    val message: String = "O valor deve começar com '{value}'",

    val idadeMinima: Int = 18,

    /**
     * Grupos de validação (opcional).
     */
    val groups: Array<KClass<*>> = [],
    /**
     * Payload para metadados extras (opcional).
     */
    val payload: Array<KClass<out Payload>> = []


)
