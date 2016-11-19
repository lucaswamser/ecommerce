package com.up.vendas.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Endereco {
	@Id
	@GeneratedValue
	private Integer idEndereco;
	private String rua;
	private String cidade;
	private String estado;
	private String pais;
	private Integer numero;
	
	public Endereco(String rua, String cidade, String estado, String pais,
			Integer numero) {
		super();
		this.rua = rua;
		this.cidade = cidade;
		this.estado = estado;
		this.pais = pais;
		this.numero = numero;
	}

	
	public Endereco() {
		super();
	}


	public Integer getIdEndereco() {
		return idEndereco;
	}

	public void setIdEndereco(Integer idEndereco) {
		this.idEndereco = idEndereco;
	}

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}
	
	
	
}
