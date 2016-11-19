package com.up.estoque.test;

import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

import com.mmnaseri.utils.spring.data.dsl.factory.RepositoryFactoryBuilder;
import com.up.estoque.domain.MovimentacaoEntrada;
import com.up.estoque.domain.MovimentacaoSaida;
import com.up.estoque.domain.Produto;
import com.up.estoque.domain.ProdutoDeposito;
import com.up.estoque.interfaces.services.DepositoService;
import com.up.estoque.interfaces.services.ProdutoService;
import com.up.estoque.repositories.DepositoRepository;
import com.up.estoque.repositories.MovimentacaoRepository;
import com.up.estoque.repositories.ProdutoRepository;
import com.up.estoque.services.DepositoServiceImpl;
import com.up.estoque.services.ProdutoServiceImpl;

public class ProdutoServiceTests {

	ProdutoRepository produtoRepository;
	ProdutoService produtoService;
	Produto produto1;
	Produto produto2;
	Produto produto3;
	@Before
	public void setUp() throws Exception {
		produtoRepository = RepositoryFactoryBuilder.builder().mock(
				ProdutoRepository.class);
		produtoService = new ProdutoServiceImpl(produtoRepository);
	}

	@Test
	public void adicionarProduto() {
		produto1 = new Produto("Produto 1",10.40,20.34);
		produto2 = new Produto("Produto 2",11.40,3.34);
		produto3 = new Produto("Produto 3",12.40,1.34);
		produtoService.adicionar(produto1);
		produtoService.adicionar(produto2);
		produtoService.adicionar(produto3);
		assertTrue(produtoService.listar().size() == 3);
	}
	
	
	

	

}
