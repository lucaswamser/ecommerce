package com.up.vendas.interfaces.services;

import com.up.vendas.domain.Frete;

public interface FreteService {
	Double calcular(Frete frete);
	Frete contratar(Frete frete);
	void confirmar(Frete frete);
	
}
