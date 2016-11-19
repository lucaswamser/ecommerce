package com.up.vendas.domain;

import javax.validation.constraints.Size;


public class CartaoDeCredito {

	@Size(min=16, max=16)
	public String numero;
	@Size(min=3, max=3)
	public Integer ccv;
	@Size(min=2, max=2)
	public String dataVencimentoMes;
	@Size(min=2, max=2)
	public String dataVencimentoAno;
	
	
	
	public CartaoDeCredito() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CartaoDeCredito(String numero, Integer ccv,
			String dataVencimentoMes, String dataVencimentoAno) {
		super();
		this.numero = numero;
		this.ccv = ccv;
		this.dataVencimentoMes = dataVencimentoMes;
		this.dataVencimentoAno = dataVencimentoAno;
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public Integer getCcv() {
		return ccv;
	}
	public void setCcv(Integer ccv) {
		this.ccv = ccv;
	}

	public String getDataVencimentoMes() {
		return dataVencimentoMes;
	}
	public void setDataVencimentoMes(String dataVencimentoMes) {
		this.dataVencimentoMes = dataVencimentoMes;
	}
	public String getDataVencimentoAno() {
		return dataVencimentoAno;
	}
	public void setDataVencimentoAno(String dataVencimentoAno) {
		this.dataVencimentoAno = dataVencimentoAno;
	}

	
	
	
	
}
