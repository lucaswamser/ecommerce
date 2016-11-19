package com.up.pagamento.dao;

import java.util.List;

import com.up.pagamento.domain.Pagamento;

public interface PagamentoDao {

	void adicionar(Pagamento pagamento);
	List<Pagamento> listar();
	
}
