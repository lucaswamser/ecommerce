package com.up.estoque.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.up.estoque.converters.DepositoCustomEditorBinder;
import com.up.estoque.converters.ProdutoCustomEditorBinder;
import com.up.estoque.domain.Deposito;
import com.up.estoque.domain.MovimentacaoEntrada;
import com.up.estoque.domain.MovimentacaoSaida;
import com.up.estoque.domain.Produto;
import com.up.estoque.interfaces.services.DepositoService;
import com.up.estoque.interfaces.services.FornecedorService;
import com.up.estoque.interfaces.services.ProdutoService;


@Controller
@RequestMapping(path="/Deposito")

public class DepositoController {

	private DepositoService depositoService;
	private ProdutoService produtoService;
	private FornecedorService fornecedorService;
	

	@Autowired
	public DepositoController(DepositoService depositoService,
			ProdutoService produtoService, FornecedorService fornecedorService) {
		super();
		this.depositoService = depositoService;
		this.produtoService = produtoService;
		this.fornecedorService = fornecedorService;
	}
	
	@InitBinder
	protected void initBinder(WebDataBinder binder) throws Exception {
	    binder.registerCustomEditor(Deposito.class, new DepositoCustomEditorBinder(depositoService));
	    binder.registerCustomEditor(Produto.class, new ProdutoCustomEditorBinder(produtoService));
	}

	
	@RequestMapping(path="/", method=RequestMethod.GET)
	public ModelAndView index(){
		ModelAndView view = new ModelAndView("deposito/index");
		view.addObject("produtos", depositoService.fazerInventario());
		return view;
	}


	@RequestMapping(path="/Movimentacao", method=RequestMethod.GET)
	public ModelAndView indexMovimentacao(){
		ModelAndView view = new ModelAndView("deposito/movimentacao/index");
		view.addObject("movimentacoes", depositoService.listarMovimentacoes());
		return view;
	}
	
	@RequestMapping(path="/Movimentacao/Remover/{id}",method=RequestMethod.GET)
	public String remover(@PathVariable("id") Integer id){
		depositoService.removerMovimentacao(id);
		return "redirect:../";
	}
	
	@RequestMapping(path="/Movimentacao/Entrada/Nova",method=RequestMethod.GET)
	public ModelAndView movimentacaoEntrada(){
		ModelAndView view = new ModelAndView("deposito/movimentacao/entradaForm");
		view.addObject("movimentacaoEntrada", new MovimentacaoEntrada());
		view.addObject("produtos", produtoService.listar());
		view.addObject("depositos", depositoService.listarDepositos());
		return view;
	}
	
	@RequestMapping(path="/Movimentacao/Entrada/Nova",method=RequestMethod.POST)
	public ModelAndView movimentacaoEntrada(@Valid MovimentacaoEntrada movimentacaoEntrada, BindingResult bind){
		if (!bind.hasErrors()){
			depositoService.movimentar(movimentacaoEntrada);
			return new ModelAndView("redirect:/Deposito/Movimentacao/");
		}
		ModelAndView view = new ModelAndView("deposito/movimentacao/entradaForm");
		view.addObject("produtos", produtoService.listar());
		view.addObject("depositos", depositoService.listarDepositos());
		return view;
	}
	
	@RequestMapping(path="/Movimentacao/Saida/Nova",method=RequestMethod.GET)
	public ModelAndView movimentacaoSaida(){
		ModelAndView view = new ModelAndView("deposito/movimentacao/saidaForm");
		view.addObject("movimentacaoSaida", new MovimentacaoSaida());
		view.addObject("produtos", produtoService.listar());
		view.addObject("depositos", depositoService.listarDepositos());
		return view;
	}
	
	@RequestMapping(path="/Movimentacao/Saida/Nova",method=RequestMethod.POST)
	public ModelAndView movimentacaoSaida(@Valid MovimentacaoSaida movimentacaoSaida, BindingResult bind){
		if (!bind.hasErrors()){
			depositoService.movimentar(movimentacaoSaida);
			return new ModelAndView("redirect:/Deposito/Movimentacao/");
		}
		ModelAndView view = new ModelAndView("deposito/movimentacao/saidaForm");
		view.addObject("produtos", produtoService.listar());
		view.addObject("depositos", depositoService.listarDepositos());
		return view;
	}
	
}
