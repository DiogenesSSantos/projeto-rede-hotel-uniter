package com.github.diogenessantos.apihotel.build.model

import com.github.diogenessantos.apihotel.exceptionhandller.exceptionfuncionario.CPFinvalidoException
import com.github.diogenessantos.apihotel.model.Contato
import com.github.diogenessantos.apihotel.model.Endereco
import com.github.diogenessantos.apihotel.model.Funcionario
import com.github.diogenessantos.apihotel.model.Hotel
import java.util.*

class FuncionarioBuilder {
    private var cpf: Long? = null
    private var nome: String? = null
    private var login: String? = null
    private var senha: String? = null
    private var contato: Contato? = null
    private var endereco: Endereco? = null
    private var hotel: Hotel? = null

    fun cpf (cpf : Long ) = apply {
        Objects.requireNonNull(cpf , "CPF NÃO PODE SER NULO")
        if (cpf.toString().toCharArray().size != 11 ) throw CPFinvalidoException()
        this.cpf = cpf
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

    fun build(): Funcionario {
        val cpf = this.cpf ?: throw IllegalStateException("CPF é obrigatório")
        val nome = this.nome ?: throw IllegalStateException("Nome é obrigatório")
        val login = this.login ?: throw IllegalStateException("Login é obrigatório")
        val senha = this.senha ?: throw IllegalStateException("Senha é obrigatória")
        val contato = this.contato ?: throw IllegalStateException("Contato é obrigatório")
        val endereco = this.endereco ?: throw IllegalStateException("Endereço é obrigatório")

        return Funcionario(cpf, nome, login, senha, contato, endereco, hotel)
    }




}