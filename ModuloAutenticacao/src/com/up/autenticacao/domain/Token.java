package com.up.autenticacao.domain;

import java.util.Date;

public class Token {
	
	private String token;
	private Date validade;
	
	public Token(String token, Date validade) {
		super();
		this.token = token;
		this.validade = validade;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public Date getValidade() {
		return validade;
	}
	public void setValidade(Date validade) {
		this.validade = validade;
	}
	
	

}
