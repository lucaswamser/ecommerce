package com.up.vendas.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.up.vendas.domain.Destinatario;
import com.up.vendas.domain.ItemPedido;
import com.up.vendas.domain.Pedido;
import com.up.vendas.domain.ProdutoDeposito;
import com.up.vendas.interfaces.services.DepositoService;
import com.up.vendas.interfaces.services.FreteService;

@Service
@RequestMapping(path = "/Carrinho")
public class CarrinhoController {
	private DepositoService depositoService;
	private FreteService freteService;

	@Autowired
	public CarrinhoController(DepositoService depositoService,
			FreteService freteService) {
		super();
		this.depositoService = depositoService;
		this.freteService = freteService;
	}

	@RequestMapping(path = "/")
	public ModelAndView index(HttpServletRequest request) {
		if (request.getSession().getAttribute("carrinho") == null) {
			request.getSession().setAttribute("carrinho", new Pedido());
		}
		
		ModelAndView view = new ModelAndView("pedido/carrinho/index");
		Pedido pedido = (Pedido) request.getSession().getAttribute("carrinho");
		Double totalFrete = 0.0;
		Double totalProdutos  = 0.0;
		if (pedido.getProdutos() != null && pedido.getProdutos().size() > 0)
		totalProdutos = pedido.getProdutos().stream().mapToDouble(e -> e.getTotal()).sum();
		if (pedido.getFrete().getValorTotal() != null)
			totalFrete = pedido.getFrete().getValorTotal();
		
		view.addObject("totalProdutos", totalProdutos);
		view.addObject("total", totalFrete + totalProdutos);
		return view;
	}

	@RequestMapping(path = "/", method = RequestMethod.POST)
	public String adicionarDestinatario(HttpServletRequest request,
			@RequestParam("cep") String cep) {
		Pedido pedido = (Pedido) request.getSession().getAttribute("carrinho");
		pedido.getFrete().setDestinatario(new Destinatario(cep));
		pedido.setValorFrete(freteService.calcular(pedido.getFrete()));
		return "redirect:/Carrinho/";
	}

	@RequestMapping(path = "/LimparDestinatario")
	public String limparDestinatario(HttpServletRequest request) {
		Pedido pedido = (Pedido) request.getSession().getAttribute("carrinho");
		pedido.getFrete().setDestinatario(null);
		return "redirect:/Carrinho/";
	}
	
	@RequestMapping(path = "/Esvaziar")
	public String esvaziar(HttpServletRequest request) {
		request.getSession().removeAttribute("carrinho");
		return "redirect:/Carrinho/";
	}


	@RequestMapping(path = "/Adicionar/{id}/{quantidade}")
	public String adicionar(HttpServletRequest request,
			@PathVariable("id") Integer id,
			@PathVariable("quantidade") Integer quantidade) {
		if (request.getSession().getAttribute("carrinho") == null) {
			request.getSession().setAttribute("carrinho", new Pedido());
		}

		Pedido pedido = (Pedido) request.getSession().getAttribute("carrinho");
		ProdutoDeposito produto = depositoService.carregarProdutoPorId(id);
		pedido.adicionarProduto(new ItemPedido(produto.getIdProduto(),produto.getNome(),produto.getPreco(),quantidade, produto.getPeso()));
		if (pedido.getFrete().existeDestinatario())
			pedido.setValorFrete(freteService.calcular(pedido.getFrete()));
		return "redirect:/Carrinho/";
	}

	@RequestMapping(path = "/Remover/{id}/{quantidade}")
	public String remover(HttpServletRequest request,
			@PathVariable("id") Integer id,
			@PathVariable("quantidade") Integer quantidade) {

		Pedido pedido = (Pedido) request.getSession().getAttribute("carrinho");
		ProdutoDeposito produto = depositoService.carregarProdutoPorId(id);
		pedido.removerProduto(new ItemPedido(produto.getIdProduto(),produto.getNome(),produto.getPreco(),quantidade, produto.getPeso()));
		if (pedido.getFrete().existeDestinatario())
			pedido.setValorFrete(freteService.calcular(pedido.getFrete()));
		return "redirect:/Carrinho/";
	}
}
