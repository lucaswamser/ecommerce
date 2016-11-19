package com.up.estoque.domain;

public class ProdutoDeposito extends Produto {
	
	private Integer quantidade;

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public ProdutoDeposito(Produto produto) {
		this.setNome(produto.getNome());
		this.setPeso(produto.getPeso());
		this.setPreco(produto.getPreco());
		this.setIdProduto(produto.getIdProduto());
	}

	@Override
	public String toString() {
		return "ProdutoDeposito [quantidade=" + quantidade + "]";
	}

	

	
}
