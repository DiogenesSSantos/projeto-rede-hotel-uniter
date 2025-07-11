package com.github.diogenessantos.apihotel.repository

import com.github.diogenessantos.apihotel.model.Funcionario

interface TesteImportando {

    fun buscarPorNome (nome : String) : MutableList<Funcionario>

}