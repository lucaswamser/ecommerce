package com.up.vendas.domain;

public class Emissor {
	
	public String razaoSocial;
	public String cnpj;
	public String endereco;
	public String bairro;
	public String cep;
	public String municipio;
	public String UF;
	public Integer incricaoEstadual;
	
	
	public Emissor(String razaoSocial, String cnpj, String endereco,
			String bairro, String cep, String municipio, String uF,
			Integer incricaoEstadual) {
		super();
		this.razaoSocial = razaoSocial;
		this.cnpj = cnpj;
		this.endereco = endereco;
		this.bairro = bairro;
		this.cep = cep;
		this.municipio = municipio;
		UF = uF;
		this.incricaoEstadual = incricaoEstadual;
	}
	public String getRazaoSocial() {
		return razaoSocial;
	}
	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}
	public String getCnpj() {
		return cnpj;
	}
	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public String getBairro() {
		return bairro;
	}
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	public String getCep() {
		return cep;
	}
	public void setCep(String cep) {
		this.cep = cep;
	}
	public String getMunicipio() {
		return municipio;
	}
	public void setMunicipio(String municipio) {
		this.municipio = municipio;
	}
	public String getUF() {
		return UF;
	}
	public void setUF(String uF) {
		UF = uF;
	}
	public Integer getIncricaoEstadual() {
		return incricaoEstadual;
	}
	public void setIncricaoEstadual(Integer incricaoEstadual) {
		this.incricaoEstadual = incricaoEstadual;
	}
	
	
}
