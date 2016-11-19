package com.up.autenticacao.domain;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Usuario {

	@Id
	@GeneratedValue
	private Integer idUsuario;
	private String nome;
	@OneToOne(cascade = CascadeType.ALL)
	private Credencial credencial;
	private String perfil;
	private String email;
	
	public Usuario() {
		super();
	}

	public Usuario(String nome, Credencial credencial, String perfil) {
		super();
		this.nome = nome;
		this.credencial = credencial;
		this.perfil = perfil;
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
	public void setCredencial(Credencial credencial) {
		this.credencial = credencial;
	}
	
	public Credencial getCredencial() {
		return credencial;
	}

	public String getPerfil() {
		return perfil;
	}
	public void setPerfil(String perfil) {
		this.perfil = perfil;
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public boolean verificaSenha(String senha){
		return senha.equals(this.credencial.getSenha());
	}

	
	
	
	
	
}
