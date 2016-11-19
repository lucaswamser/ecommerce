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
import com.up.estoque.repositories.DepositoRepository;
import com.up.estoque.repositories.MovimentacaoRepository;
import com.up.estoque.repositories.ProdutoRepository;
import com.up.estoque.services.DepositoServiceImpl;
import com.up.estoque.services.ProdutoServiceImpl;

public class DepositoServiceTests {

	ProdutoRepository produtoRepository;
	MovimentacaoRepository movimentacaoRepository;
	DepositoRepository depositoRepository;
	DepositoService depositoService;
	Produto produto1;
	Produto produto2;
	Produto produto3;
	@Before
	public void setUp() throws Exception {
		produtoRepository = RepositoryFactoryBuilder.builder().mock(
				ProdutoRepository.class);
		movimentacaoRepository = RepositoryFactoryBuilder.builder().mock(
				MovimentacaoRepository.class);
		depositoRepository = RepositoryFactoryBuilder.builder().mock(
				DepositoRepository.class);
		produto1 = new Produto("Produto 1",10.40,20.34);
		produtoRepository.saveAndFlush(produto1);
		produto2 = new Produto("Produto 2",11.40,3.34);
		produtoRepository.saveAndFlush(produto2);
		produto3 = new Produto("Produto 3",12.40,1.34);
		produtoRepository.saveAndFlush(produto3);
		depositoService = new DepositoServiceImpl(movimentacaoRepository, depositoRepository, new ProdutoServiceImpl(produtoRepository));
	}

	@Test
	public void testEntradaEstoque() {
		produto1 = new Produto("Produto 1",10.40,20.34);
		produtoRepository.saveAndFlush(produto1);
		MovimentacaoEntrada me = new MovimentacaoEntrada();
		me.setDate(new Date());
		me.setProduto(produto1);
		me.setQuantidade(100);
		depositoService.movimentar(me);
		assertTrue(buscarPorIdQuantidade(produto1.getIdProduto(), 100, depositoService.fazerInventario()) != null);
		
	}
	
	@Test
	public void testSaidaEstoque() {
		produto1 = new Produto("Produto 1",10.40,20.34);
		produtoRepository.saveAndFlush(produto1);
		MovimentacaoEntrada me = new MovimentacaoEntrada();
		me.setDate(new Date());
		me.setProduto(produto1);
		me.setQuantidade(100);
		depositoService.movimentar(me);
		MovimentacaoSaida ms = new MovimentacaoSaida();
		ms.setDate(new Date());
		ms.setProduto(produto1);
		ms.setQuantidade(10);
		depositoService.movimentar(ms);
		assertTrue(buscarPorIdQuantidade(produto1.getIdProduto(), 90, depositoService.fazerInventario()) != null);
		
	}
	
	
	private ProdutoDeposito buscarPorIdQuantidade(Integer id, Integer quantidade, List<ProdutoDeposito> lista){
		
		for (ProdutoDeposito produtoDeposito : lista) {
			if (produtoDeposito.getIdProduto() == id && produtoDeposito.getQuantidade() == quantidade)
				return produtoDeposito;
		}
		return null;
		
	}
	
	

}
