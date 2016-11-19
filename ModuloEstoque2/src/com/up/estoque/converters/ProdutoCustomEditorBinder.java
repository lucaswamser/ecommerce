package com.up.estoque.converters;

import java.beans.PropertyEditorSupport;

import org.springframework.stereotype.Component;

import com.up.estoque.interfaces.services.ProdutoService;

public class ProdutoCustomEditorBinder extends PropertyEditorSupport {
	private ProdutoService produtoService;

	
	
	public ProdutoCustomEditorBinder() {
		super();
	}


	public ProdutoCustomEditorBinder(ProdutoService produtoService) {
		super();
		this.produtoService = produtoService;
	}


	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		setValue(produtoService.carregarPorId(Integer.valueOf(text)));
	}

}
