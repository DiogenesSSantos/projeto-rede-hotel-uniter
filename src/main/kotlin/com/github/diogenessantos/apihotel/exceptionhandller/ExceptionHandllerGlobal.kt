package com.github.diogenessantos.apihotel.exceptionhandller

import com.github.diogenessantos.apihotel.exceptionhandller.exceptionfuncionario.CPFinvalidoException
import com.github.diogenessantos.apihotel.exceptionhandller.exceptionfuncionario.FuncionarioJaCadastroException
import com.github.diogenessantos.apihotel.exceptionhandller.exceptionfuncionario.FuncionarioNaoExisteException
import com.github.diogenessantos.apihotel.exceptionhandller.exceptionhotel.HotelNaoLocalizadoException
import com.github.diogenessantos.apihotel.exceptionhandller.model.Problem
import jakarta.servlet.http.HttpServletRequest
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.MissingServletRequestParameterException
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


    @ExceptionHandler(MissingServletRequestParameterException::class)
    fun MissingServletRequestParameterException(ex : MissingServletRequestParameterException ,
                                                request: HttpServletRequest) : ResponseEntity<Any>? {

        val parametoFalho = ex.parameterName

        val problem = Problem(
            HttpStatus.BAD_REQUEST.value(), " O PARAMETRO COM CAMPO [${parametoFalho.uppercase()}] ESTÁ FALHO",
            "ERRO DE PARAMETRO NA REQUISIÇÃO",
            LocalDateTime.now(),
            MissingServletRequestParameterException::class.toString()
        )

        return ResponseEntity(problem, HttpStatus.BAD_REQUEST)
    }

    @ExceptionHandler(HotelNaoLocalizadoException::class)
    fun HotelNaoLocalizadoException(ex : HotelNaoLocalizadoException,
                                    request: HttpServletRequest) : ResponseEntity<Any>? {


        val problem = Problem(
            HttpStatus.BAD_REQUEST.value(), ex.message!!,
            "Dado não existente no banco de dados.",
            LocalDateTime.now(),
            HotelNaoLocalizadoException::class.toString()
        )

        return ResponseEntity(problem, HttpStatus.BAD_REQUEST)
    }


    @ExceptionHandler(FuncionarioNaoExisteException::class)
    fun HotelNaoLocalizadoException(ex : FuncionarioNaoExisteException,
                                    request: HttpServletRequest) : ResponseEntity<Any>? {


        val problem = Problem(
            HttpStatus.BAD_REQUEST.value(), ex.message!!,
            "Dado não existente no banco de dados.",
            LocalDateTime.now(),
            FuncionarioNaoExisteException::class.toString()
        )

        return ResponseEntity(problem, HttpStatus.BAD_REQUEST)
    }



    @ExceptionHandler(FuncionarioJaCadastroException::class)
    fun HotelNaoLocalizadoException(ex : FuncionarioJaCadastroException,
                                    request: HttpServletRequest) : ResponseEntity<Any>? {


        val problem = Problem(
            HttpStatus.BAD_REQUEST.value(), ex.message!!,
            "CPF JÁ CADASTRADO.",
            LocalDateTime.now(),
            FuncionarioJaCadastroException::class.toString()
        )

        return ResponseEntity(problem, HttpStatus.BAD_REQUEST)
    }


}