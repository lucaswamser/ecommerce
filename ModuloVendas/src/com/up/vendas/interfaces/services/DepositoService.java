package com.up.vendas.interfaces.services;

import java.util.List;

import com.up.vendas.domain.ItemPedido;
import com.up.vendas.domain.ProdutoDeposito;

public interface DepositoService {

	
	List<ProdutoDeposito> listarProdutosDisponiveis();
	ProdutoDeposito carregarProdutoPorId(Integer id);
	void retirarProduto(ItemPedido itemPedido);

}
