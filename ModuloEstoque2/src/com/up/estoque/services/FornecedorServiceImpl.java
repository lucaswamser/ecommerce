package com.up.estoque.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.up.estoque.domain.Fornecedor;
import com.up.estoque.interfaces.services.FornecedorService;
import com.up.estoque.repositories.FornecedorRepository;

@Service
public class FornecedorServiceImpl implements FornecedorService {

	private FornecedorRepository fornecedorRepository;
	
	@Autowired
	public FornecedorServiceImpl(FornecedorRepository fornecedorRepository) {
		super();
		this.fornecedorRepository = fornecedorRepository;
	}

	@Override
	public void adicionar(Fornecedor fornecedor) {
		fornecedorRepository.save(fornecedor);
	}

	@Override
	public void atualizar(Fornecedor fornecedor) {
		fornecedorRepository.save(fornecedor);
	}

	@Override
	public void remover(Integer id) {
		fornecedorRepository.delete(id);
	}

	@Override
	public List<Fornecedor> listar() {
		return fornecedorRepository.findAll();
	}

	@Override
	public Fornecedor carregarPorId(Integer id) {
		return fornecedorRepository.findOne(id);
		
	}

}
