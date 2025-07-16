package com.github.diogenessantos.apihotel.exceptionhandller.exceptionfuncionario

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ResponseStatus
import java.lang.RuntimeException

@ResponseStatus(HttpStatus.BAD_REQUEST)
class CPFinvalidoException(message: String =  "TAMANHO DO CPF DEVE CONTER 11 CARACTERES SEM DIGITOS ESPECIAIS")
    : RuntimeException(message) {
}