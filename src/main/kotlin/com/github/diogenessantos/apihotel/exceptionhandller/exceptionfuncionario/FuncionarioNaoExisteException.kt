package com.github.diogenessantos.apihotel.exceptionhandller.exceptionfuncionario

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ResponseStatus


@ResponseStatus(HttpStatus.BAD_REQUEST)
class FuncionarioNaoExisteException (mensagem : String = "Funcionário não existe no banco de dados")
    : RuntimeException(mensagem) {
}