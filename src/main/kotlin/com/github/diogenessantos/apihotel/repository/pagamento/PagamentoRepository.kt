package com.github.diogenessantos.apihotel.repository.pagamento

import com.github.diogenessantos.apihotel.model.Pagamento
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository


@Repository
interface PagamentoRepository : JpaRepository<Pagamento, Long> {
}