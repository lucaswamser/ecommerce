package com.up.vendas.domain;

import java.io.Serializable;

public class Credencial implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer idCredencial;
	private String usuario;
	private String senha;

	public Credencial(String usuario, String senha) {
		super();
		this.usuario = usuario;
		this.senha = senha;
	}

	public Credencial() {
		super();
	}

	public Integer getIdCredencial() {
		return idCredencial;
	}

	public void setIdCredencial(Integer idCredencial) {
		this.idCredencial = idCredencial;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

}
