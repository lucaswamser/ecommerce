package com.up.vendas.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.up.vendas.domain.ItemPedido;
import com.up.vendas.domain.Produto;
import com.up.vendas.domain.ProdutoDeposito;
import com.up.vendas.interfaces.services.DepositoService;
import com.up.vendas.repositories.ProdutoDepositoRepository;

@Service
public class DepositoServiceProxy implements DepositoService {
	RestTemplate template;
	@Autowired
	RabbitTemplate rabbitTemplate;
	
	@Autowired
	ProdutoDepositoRepository repository;
	
	public DepositoServiceProxy() {
		this.template = new RestTemplate();
	}

	@Override
	public List<ProdutoDeposito> listarProdutosDisponiveis() {
		final String uri = "http://localhost:8080/ModuloEstoque2/rest/Deposito/produtos";
		List<ProdutoDeposito> produtos = Arrays.asList(template.getForObject(uri, ProdutoDeposito[].class));
		System.out.println(produtos.size());
		return  produtos;
		
	}
	
	public void atualizar(ProdutoDeposito pd){
		repository.save(pd);
	}

	@Override
	public ProdutoDeposito carregarProdutoPorId(Integer id) {
		final String uri = "http://localhost:8080/ModuloEstoque2/rest/Deposito/produto/"+String.valueOf(id);
		return template.getForObject(uri, ProdutoDeposito.class);
	}

	@Override
	public void retirarProduto(ItemPedido itemPedido) {
		rabbitTemplate.setRoutingKey("estoque.movimentacoes");
		//final String uri = "http://localhost:8080/ModuloEstoque2/rest/Deposito/baixar/"+itemPedido.getIdProduto()+"/"+itemPedido.getQuantidade();
	    //template.getForObject(uri, Boolean.class);
		rabbitTemplate.convertAndSend("ordemsaida,"+itemPedido.getQuantidade()+","+itemPedido.getIdProduto());
	}

	
}
