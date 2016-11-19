package com.up.vendas.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class ItemPedido {
	@Id
	@GeneratedValue
	private Integer idItemPedido;

	private Integer idProduto;
	private String nome;
	private Double precoUnitario;
	private Double peso;
	
	private Integer quantidade;
	@ManyToOne
	@JoinColumn(name="idPedido")
	private Pedido pedido;
	
	private Double total;

	public ItemPedido() {
		super();
		// TODO Auto-generated constructor stub
	}


	public ItemPedido(Integer idProduto, String nome, Double precoUnitario,
			Integer quantidade, Double peso) {
		super();
		this.idProduto = idProduto;
		this.nome = nome;
		this.precoUnitario = precoUnitario;
		this.quantidade = quantidade;
		this.peso = peso;
		this.total = precoUnitario * this.quantidade;
	}


	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
		this.total = precoUnitario * this.quantidade;
	}

	public Double getTotal() {
		return total;
	}

	public void setTotal(Double total) {
		this.total = total;
	}

	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}


	public Integer getIdItemPedido() {
		return idItemPedido;
	}


	public void setIdItemPedido(Integer idItemPedido) {
		this.idItemPedido = idItemPedido;
	}


	public Integer getIdProduto() {
		return idProduto;
	}


	public void setIdProduto(Integer idProduto) {
		this.idProduto = idProduto;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public Double getPrecoUnitario() {
		return precoUnitario;
	}


	public void setPrecoUnitario(Double precoUnitario) {
		this.precoUnitario = precoUnitario;
	}


	public Double getPeso() {
		return peso;
	}


	public void setPeso(Double peso) {
		this.peso = peso;
	}



}
