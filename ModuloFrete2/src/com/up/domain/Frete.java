package com.up.domain;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Transient;

@Entity
public class Frete {

	@GeneratedValue
	@Id
	private Integer idFrete;
	@OneToOne(cascade=CascadeType.ALL)
	private Destinatario destinatario;
	@OneToOne(cascade=CascadeType.ALL)
	private Usuario usuario;
	private Double peso;
	private Double valorTotal;
	private String status;
	private Date data;
	
	

	public Frete() {
		super();
		// TODO Auto-generated constructor stub
	}







	public Frete(Destinatario destinatario, Usuario usuario, Double peso, String status, Date data) {
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







	public void setDestinatario(Destinatario destinatario) {
		this.destinatario = destinatario;
	}







	public void calcular() {
		Double 	valorTotal = peso * 0.10;
		this.valorTotal = valorTotal;
	}

}
