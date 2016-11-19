package com.up.vendas.domain;

import javax.persistence.Entity;

@Entity
public class ProdutoDeposito extends Produto {
	
	private Integer quantidade;

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	
	public ProdutoDeposito() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ProdutoDeposito(Produto produto) {
		this.setNome(produto.getNome());
		this.setPeso(produto.getPeso());
		this.setPreco(produto.getPreco());
		this.setIdProduto(produto.getIdProduto());
	}

	

	
}
