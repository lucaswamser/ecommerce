package com.up.estoque.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.up.estoque.domain.ProdutoDeposito;
import com.up.estoque.domain.Produto;
import com.up.estoque.interfaces.services.ProdutoService;
import com.up.estoque.repositories.ProdutoRepository;

@Service
public class ProdutoServiceImpl implements ProdutoService {

	private ProdutoRepository produtoRepository;
	
	@Autowired
	public ProdutoServiceImpl(ProdutoRepository produtoRepository) {
		super();
		this.produtoRepository = produtoRepository;
	}

	@Override
	public void adicionar(Produto produto) {
		produtoRepository.save(produto);
	}

	@Override
	public void atualizar(Produto produto) {
		produtoRepository.save(produto);
	}

	@Override
	public void remover(Integer id) {
		produtoRepository.delete(id);
	}

	@Override
	public List<Produto> listar() {
		return produtoRepository.findAll();
	}

	@Override
	public Produto carregarPorId(Integer id) {
		return produtoRepository.findOne(id);
		
	}

	@Override
	public List<ProdutoDeposito> listarProdutosDeposito() {
		// TODO Auto-generated method stub
		return null;
	}

}
