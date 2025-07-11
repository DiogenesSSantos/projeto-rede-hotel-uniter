package com.github.diogenessantos.apihotel.repository

import com.github.diogenessantos.apihotel.model.Contato
import com.github.diogenessantos.apihotel.model.Endereco
import com.github.diogenessantos.apihotel.model.Funcionario
import com.github.diogenessantos.apihotel.model.Hotel

class TesteImportandoImpl : TesteImportando {
    override fun buscarPorNome(nome: String): MutableList<Funcionario> {
        return mutableListOf(Funcionario(1248587943 , "diogenes" ,
            "dio" , "123", Contato("null", "null"),
            Endereco("dio", null, null , null ), null)
            )
    }
}