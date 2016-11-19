package com.up.vendas.domain;

import javax.validation.constraints.Size;

public class Destinatario {

	private Integer idDestinatario;
	@Size(min=4, max=50)
	private String nome;
	@Size(min=6, max=6)
	private String cep;
	@Size(min=4, max=100)
	private String rua;
	@Size(min=4, max=100)
	private String cidade;
	@Size(min=4, max=100)
	private String estado;
	private String pais;
	@Size(min=4, max=15)
	private String telefone;
	private Integer numero;
	private String cpfCnpj;
	private String email;
	

	



	public Destinatario(String nome, String cep, String rua, String cidade,
			String estado, String pais, String telefone, Integer numero,
			String cpfCnpj, String email) {
		super();
		this.nome = nome;
		this.cep = cep;
		this.rua = rua;
		this.cidade = cidade;
		this.estado = estado;
		this.pais = pais;
		this.telefone = telefone;
		this.numero = numero;
		this.cpfCnpj = cpfCnpj;
		this.email = email;
	}


	public Destinatario(String cep) {
		super();
		this.cep = cep;
	}

	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Destinatario() {
		super();
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

	public Integer getIdDestinatario() {
		return idDestinatario;
	}

	public void setIdDestinatario(Integer idDestinatario) {
		this.idDestinatario = idDestinatario;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}


	public String getTelefone() {
		return telefone;
	}


	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}


	public String getCpfCnpj() {
		return cpfCnpj;
	}


	public void setCpfCnpj(String cpfCnpj) {
		this.cpfCnpj = cpfCnpj;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}
	
	

}
