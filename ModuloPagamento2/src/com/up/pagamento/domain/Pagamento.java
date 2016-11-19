package com.up.pagamento.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlAccessType;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@Entity
public class Pagamento {

	@Id
	@GeneratedValue
	public Integer idPagamento;
	@Transient
	public CartaoDeCredito cartaoDeCredito;
	public Double valorPagamento;
	public Boolean aceito;
	public Date data;
	
	
	public Integer getIdPagamento() {
		return idPagamento;
	}
	public void setIdPagamento(Integer idPagamento) {
		this.idPagamento = idPagamento;
	}

	public CartaoDeCredito getCartaoDeCredito() {
		return cartaoDeCredito;
	}
	public void setCartaoDeCredito(CartaoDeCredito cartaoDeCredito) {
		this.cartaoDeCredito = cartaoDeCredito;
	}
	public Double getValorPagamento() {
		return valorPagamento;
	}
	public void setValorPagamento(Double valorPagamento) {
		this.valorPagamento = valorPagamento;
	}
	public Boolean getAceito() {
		return aceito;
	}
	public void setAceito(Boolean aceito) {
		this.aceito = aceito;
	}
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	
	
}
