package com.up.services;

import java.util.ArrayList;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.up.domain.Frete;
import com.up.interfaces.services.FreteService;
import com.up.repositories.FreteRepository;

@Service
public class FreteServiceImpl implements FreteService  {

	private FreteRepository freteRepository;
	
	@Autowired
	public FreteServiceImpl(FreteRepository freteRepository) {
 		super();
 		this.freteRepository = freteRepository;
	}
	

	@Override
	public Double calcular(Frete frete) {
		frete.calcular();
		return frete.getValorTotal();	
	}

	@Override
	public Frete contratar(Frete frete) {
		frete.calcular();
		frete.setData(new Date());
		frete.setStatus("Contratado!");
		return freteRepository.save(frete);
	}

	
	public void atualizarStatus(Frete frete){
		freteRepository.saveAndFlush(frete);
	}

	public ArrayList<Frete> listar() {
		return (ArrayList<Frete>) freteRepository.findAll();
	}


	@Override
	public void confirmar(Integer idFrete) {
		Frete frete =freteRepository.getOne(idFrete);
		frete.setStatus("Confirmado");
		freteRepository.save(frete);
	}
	

}
