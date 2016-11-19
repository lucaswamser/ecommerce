package com.up.pagamento.domain;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class CartaoDeCredito {


	public String numero;

	public Integer ccv;

	public String dataVencimentoMes;

	public String dataVencimentoAno;
	
	
	
	public CartaoDeCredito() {
		super();
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

