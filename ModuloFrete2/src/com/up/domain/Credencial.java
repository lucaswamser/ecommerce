package com.up.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Credencial implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue
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
