package com.up.estoque.interfaces.services;

import java.util.List;

import com.up.estoque.domain.Deposito;
import com.up.estoque.domain.ProdutoDeposito;
import com.up.estoque.domain.Movimentacao;

public interface DepositoService {

	
	void adicionarDeposito(Deposito deposito);
	void movimentar(Movimentacao movimentacao);
	void removerMovimentacao(Integer id);
	
	List<Movimentacao> listarMovimentacoes();
	Deposito carragarDepositoPorId(Integer id);
	
	List<Deposito> listarDepositos();
	List<ProdutoDeposito> fazerInventario();
	ProdutoDeposito carregarProdutoRepositorioPorId(Integer id);

}
