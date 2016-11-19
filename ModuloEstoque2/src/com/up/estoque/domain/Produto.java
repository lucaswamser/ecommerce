package com.up.estoque.domain;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Produto {
	
	public Produto() {
		super();
	}
	@Id
	@GeneratedValue
	private Integer idProduto;
	private String nome;
	private Double peso;
	private Double preco;
	
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
	public Double getPeso() {
		return peso;
	}
	public void setPeso(Double peso) {
		this.peso = peso;
	}
	public Double getPreco() {
		return preco;
	}
	public void setPreco(Double preco) {
		this.preco = preco;
	}
	@Override
	public String toString() {
		return "Produto [idProduto=" + idProduto + ", nome=" + nome + ", peso="
				+ peso + ", preco=" + preco + "]";
	}
	public Produto(String nome, Double peso, Double preco) {
		super();
		this.nome = nome;
		this.peso = peso;
		this.preco = preco;
	}
	
	
}
