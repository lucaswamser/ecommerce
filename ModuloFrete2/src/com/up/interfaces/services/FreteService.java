package com.up.interfaces.services;

import java.util.ArrayList;

import com.up.domain.Frete;

public interface FreteService {
	Double calcular(Frete frete);
	Frete contratar(Frete frete);
	void confirmar(Integer frete);
	ArrayList<Frete> listar();
	
}
