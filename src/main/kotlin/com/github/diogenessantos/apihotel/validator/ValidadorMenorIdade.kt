package com.github.diogenessantos.apihotel.validator

import jakarta.validation.ConstraintValidator
import jakarta.validation.ConstraintValidatorContext

class ValidadorMenorIdade : ConstraintValidator<MenorDeIdade, Int> {

    private var idadeMinima: Int = 18 ;

    override fun initialize(constraintAnnotation: MenorDeIdade) {
        this.idadeMinima = constraintAnnotation.idadeMinima
    }

    override fun isValid(p0: Int?, p1: ConstraintValidatorContext?): Boolean {
        return p0!! < idadeMinima
    }
}