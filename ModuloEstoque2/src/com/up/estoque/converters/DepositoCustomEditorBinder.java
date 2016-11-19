package com.up.estoque.converters;

import java.beans.PropertyEditorSupport;

import org.springframework.beans.factory.annotation.Autowired;

import com.up.estoque.interfaces.services.DepositoService;


public class DepositoCustomEditorBinder extends PropertyEditorSupport{

	private DepositoService depositoService;

	
	public DepositoCustomEditorBinder() {
		super();
	}


	public DepositoCustomEditorBinder(DepositoService depositoService) {
		super();
		this.depositoService = depositoService;
	}


	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		setValue(depositoService.carragarDepositoPorId(Integer.valueOf(text)));
	}

	
	
	
	


}
