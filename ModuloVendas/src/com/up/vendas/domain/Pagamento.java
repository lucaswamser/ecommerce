package com.up.vendas.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Transient;

@Entity
public class Pagamento {

	@Id
	@GeneratedValue
	public Integer idPagamento;
	@Transient
	public CartaoDeCredito cartaoDeCredito;
	public Double valorPagamento;
	public String status;
	
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
	
	
}
