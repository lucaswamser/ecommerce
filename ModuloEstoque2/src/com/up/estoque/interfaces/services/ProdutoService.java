package com.up.estoque.interfaces.services;

import java.util.List;

import com.up.estoque.domain.ProdutoDeposito;
import com.up.estoque.domain.Produto;


public interface ProdutoService {
	
	void adicionar(Produto produto);
	void atualizar(Produto produto);
	Produto carregarPorId(Integer id);
	void remover(Integer id);
	List<Produto> listar();
	List<ProdutoDeposito> listarProdutosDeposito();
	
}
