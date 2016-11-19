package com.up.estoque.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.up.estoque.domain.Deposito;
import com.up.estoque.domain.ProdutoDeposito;
import com.up.estoque.domain.Movimentacao;
import com.up.estoque.domain.MovimentacaoEntrada;
import com.up.estoque.domain.MovimentacaoSaida;
import com.up.estoque.domain.Produto;
import com.up.estoque.interfaces.services.DepositoService;
import com.up.estoque.interfaces.services.ProdutoService;
import com.up.estoque.repositories.DepositoRepository;
import com.up.estoque.repositories.MovimentacaoRepository;

@Service
public class DepositoServiceImpl implements DepositoService {

	private MovimentacaoRepository movimentacaoRepository;
	private DepositoRepository depositoRepository;
	private ProdutoService produtoService;

	@Autowired
	public DepositoServiceImpl(MovimentacaoRepository movimentacaoRepository,
			DepositoRepository depositoRepository, ProdutoService produtoService) {
		super();
		this.movimentacaoRepository = movimentacaoRepository;
		this.depositoRepository = depositoRepository;
		this.produtoService = produtoService;
	}

	@Override
	public void adicionarDeposito(Deposito deposito) {
		// TODO Auto-generated method stub

	}

	@Override
	public void movimentar(Movimentacao movimentacao) {
		movimentacao.setDate(new Date());
		movimentacaoRepository.save(movimentacao);
	}

	@Override
	public void removerMovimentacao(Integer id) {
		movimentacaoRepository.delete(id);

	}

	@Override
	public List<Deposito> listarDepositos() {
		return depositoRepository.findAll();
	}

	@Override
	public Deposito carragarDepositoPorId(Integer id) {
		return depositoRepository.findOne(id);
	}

	@Override
	public List<Movimentacao> listarMovimentacoes() {
		return movimentacaoRepository.findAll();
	}

	
	@Override
	public List<ProdutoDeposito> fazerInventario() {
		List<ProdutoDeposito> items = new ArrayList<ProdutoDeposito>();
		List<Produto> produtos = produtoService.listar();
		for (Produto produto : produtos) {
			ProdutoDeposito produtoDeposito = inventarioContarProduto(produto);
			if (produtoDeposito.getQuantidade() > 0)
			items.add(produtoDeposito);
		}
		
		return items;
	}
	
	@Override
	public ProdutoDeposito carregarProdutoRepositorioPorId(Integer id){
		return inventarioContarProduto(produtoService.carregarPorId(id));
	}
	
	private ProdutoDeposito inventarioContarProduto(Produto produto){
		Integer quantidade = 0;
		for (Movimentacao movimentacao : movimentacaoRepository
				.findByProduto(produto)) {
			if (movimentacao instanceof MovimentacaoEntrada)
				quantidade = quantidade + movimentacao.getQuantidade();
			if (movimentacao instanceof MovimentacaoSaida)
				quantidade = quantidade - movimentacao.getQuantidade();
		}
		ProdutoDeposito produtoDeposito = new ProdutoDeposito(produto);
		produtoDeposito.setQuantidade(quantidade);
		return produtoDeposito;
	}

}
