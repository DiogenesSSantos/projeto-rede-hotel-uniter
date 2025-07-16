package com.github.diogenessantos.apihotel.build.model

import com.github.diogenessantos.apihotel.exceptionhandller.exceptionfuncionario.CPFinvalidoException
import com.github.diogenessantos.apihotel.model.Contato
import com.github.diogenessantos.apihotel.model.Endereco
import com.github.diogenessantos.apihotel.model.Funcionario
import com.github.diogenessantos.apihotel.model.Hotel
import java.util.*

class FuncionarioBuilder(
    private var CPF: Long,
    private var nome: String,
    private var login: String,
    private var senha: String,
    private var contato: Contato,
    private var endereco: Endereco,
    private var hotel: Hotel?


)  {

    fun cpf (cpf : Long ) = apply {
        Objects.requireNonNull(cpf , "CPF NÃO PODE SER NULO")
        if (cpf.toString().toCharArray().size != 11 ) throw CPFinvalidoException()
        this.CPF = cpf
    }

    fun nome (nome: String?) = apply {
        Objects.requireNonNull(nome , "NOME NÃO PODE SER NULO")
        if (nome != null) {
            this.nome = nome
        }
    }

    fun login (login : String ) = apply {
        Objects.requireNonNull(login , "LOGIN NÃO PODE SER NULO")
        this.login = login
    }

    fun senha (senha : String ) = apply {
        Objects.requireNonNull(senha , "SENHA NÃO PODE SER NULO")
        this.senha = senha
    }

    fun contato (contato : Contato ) = apply {
        this.contato = contato
    }

    fun endereco(endereco: Endereco) = apply {
        this.endereco = endereco
    }

    fun hotel (hotel: Hotel?) = apply {
        this.hotel = hotel
    }


    fun builder() : Funcionario {
        return Funcionario(this.CPF , this.nome , this.login , this.senha,
            this.contato, this.endereco , this.hotel)
    }




}