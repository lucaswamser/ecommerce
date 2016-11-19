package com.up.vendas.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;

@Entity
public class Frete {
	
	@Id
	private Integer idFrete;
	@Transient
	private Destinatario destinatario;
	@Transient
	private Usuario usuario;
	@Transient
	private Double peso;
	private Double valorTotal;
	@Transient
	private String status;
	@Transient
	private Date data;

	public Frete() {
	}

	public Frete(Destinatario destinatario, Usuario usuario, Double peso,
			String status, Date data) {
		super();
		this.destinatario = destinatario;
		this.usuario = usuario;
		this.peso = peso;
		this.status = status;
		this.data = data;
	}

	public Integer getIdFrete() {
		return idFrete;
	}

	public void setIdFrete(Integer idFrete) {
		this.idFrete = idFrete;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Double getPeso() {
		if (this.peso == null)
			peso = 0.0;
		return peso;
	}

	public void setPeso(Double peso) {
		this.peso = peso;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public Double getValorTotal() {
		return valorTotal;
	}

	public Destinatario getDestinatario() {
		return destinatario;
	}
	
	public Boolean existeDestinatario(){
		return destinatario != null;
	}

	public void setDestinatario(Destinatario destinatario) {
		this.destinatario = destinatario;
	}

	public void setValorTotal(Double valorTotal) {
		this.valorTotal = valorTotal;
	}



}
