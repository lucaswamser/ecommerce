package com.up.vendas.services;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.up.vendas.domain.Frete;
import com.up.vendas.domain.Usuario;
import com.up.vendas.interfaces.services.FreteService;

@Service
public class FreteServiceProxy implements FreteService {

	RestTemplate template;
	
	public FreteServiceProxy() {
		this.template = new RestTemplate();
	}

	
	@Override
	public Double calcular(Frete frete) {
		final String uri = "http://localhost:8080/ModuloFrete2/rest/Frete/calcular";
		RestTemplate template = new RestTemplate();
		 return template.postForObject(uri,frete,Double.class);
	}

	@Override
	public Frete contratar(Frete frete) {
		final String uri = "http://localhost:8080/ModuloFrete2/rest/Frete/contratar";
		RestTemplate template = new RestTemplate();
		System.out.println("calculando o frete para" + frete.getDestinatario().getCep() + "peso" + frete.getPeso());
		return template.postForObject(uri,frete, Frete.class);
	}

	@Override
	public void confirmar(Frete frete) {
		// TODO Auto-generated method stub
		
	}

}
