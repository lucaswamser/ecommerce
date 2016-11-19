package com.up.estoque.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.up.estoque.domain.Produto;
import com.up.estoque.interfaces.services.ProdutoService;

@Controller
@RequestMapping(path = "/Produto")
public class ProdutoController {
	
	private ProdutoService produtoService;
	
	@Autowired
	public ProdutoController(ProdutoService produtoService) {
		super();
		this.produtoService = produtoService;
	}
	
	@RequestMapping(path="/",method=RequestMethod.GET)
	public ModelAndView index(){
		ModelAndView view = new ModelAndView("produto/index");
		view.addObject("produtos", produtoService.listar());
		return view;
	}
	
	@RequestMapping(path="/Adicionar",method=RequestMethod.GET)
	public ModelAndView adicionar(){
		ModelAndView view = new ModelAndView("produto/form");
		view.addObject("produto", new Produto());
		return view;
	}
	
	@RequestMapping(path = "/Adicionar", method = RequestMethod.POST)
	public String cadastrar(@Valid Produto produto, BindingResult bind) {
		if (!bind.hasErrors()) {
			produtoService.adicionar(produto);
			return "redirect:/Produto/";
		}
		return "produto/form";
	}
	
	@RequestMapping(path="/Atualizar/{id}",method=RequestMethod.GET)
	public ModelAndView atualizar(@PathVariable("id") Integer id){
		ModelAndView view = new ModelAndView("produto/form");
		view.addObject("produto", produtoService.carregarPorId(id));
		return view;
	}
	
	@RequestMapping(path = "/Atualizar/{id}", method = RequestMethod.POST)
	public String atualizar(@Valid Produto produto,BindingResult bind) {
		if (!bind.hasErrors()) {
			produtoService.atualizar(produto);
			return "redirect:/Produto/";
		}
		return "produto/form";
	}
	
	@RequestMapping(path="/Remover/{id}",method=RequestMethod.GET)
	public String remover(@PathVariable("id") Integer id){
		produtoService.remover(id);
		return "redirect:/Produto/";
	}
}
