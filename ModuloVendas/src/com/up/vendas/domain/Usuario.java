package com.up.vendas.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Transient;

@Entity
public class Usuario {
	
	@Id
	private Integer idUsuario;
	private String nome;
	@Transient 
	private String perfil;
	@Transient
	private String email;
	@Transient
	private Credencial credencial;
	
	public Usuario() {
		super();
	}

	public Usuario(String nome) {
		super();
		this.nome = nome;
	}

	public Integer getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(Integer idUsuario) {
		this.idUsuario = idUsuario;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getPerfil() {
		return perfil;
	}

	public void setPerfil(String perfil) {
		this.perfil = perfil;
	}

	public Credencial getCredencial() {
		return credencial;
	}

	public void setCredencial(Credencial credencial) {
		this.credencial = credencial;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	
	

}
