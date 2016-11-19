package com.up.estoque.interfaces.services;

import java.util.List;

import com.up.estoque.domain.Fornecedor;
import com.up.estoque.domain.Produto;


public interface FornecedorService {
	
	void adicionar(Fornecedor fornecedor);
	void atualizar(Fornecedor fornecedor);
	Fornecedor carregarPorId(Integer id);
	void remover(Integer id);
	List<Fornecedor> listar();
	
}
