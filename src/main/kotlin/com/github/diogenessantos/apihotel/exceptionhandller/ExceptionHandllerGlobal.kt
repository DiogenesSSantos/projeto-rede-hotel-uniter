package com.github.diogenessantos.apihotel.exceptionhandller

import com.github.diogenessantos.apihotel.exceptionhandller.exceptionfuncionario.CPFinvalidoException
import com.github.diogenessantos.apihotel.exceptionhandller.model.Problem
import jakarta.servlet.http.HttpServletRequest
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import java.time.LocalDateTime


/**
 * @author DiogenesSSantos
 *
 *classe para captura de exception globalmente
 *
 */
@ControllerAdvice
class ExceptionHandllerGlobal {

    @ExceptionHandler(CPFinvalidoException::class)
    fun handleCPFInvalidadoException(ex: CPFinvalidoException, request: HttpServletRequest): ResponseEntity<Any>? {


        val problem = Problem(
            HttpStatus.BAD_REQUEST.value(), ex.message!!,
            "CPF INVALIDO",
            LocalDateTime.now(),
            CPFinvalidoException::class.toString()
        )

        return ResponseEntity(problem, HttpStatus.BAD_REQUEST)
    }



}