package com.up.vendas.interfaces.services;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import com.up.vendas.domain.NotaFiscal;


public interface NotaFiscalService {

	public void enviarNota(NotaFiscal nfe);
	
}
