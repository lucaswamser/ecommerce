package com.up.pagamento.services;

import java.util.List;

import com.up.pagamento.domain.Pagamento;


public interface PagamentoService {
	
	Boolean pagar(Pagamento pagamento);
	List<Pagamento> listar();

}
