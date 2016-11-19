package com.up.vendas.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.up.vendas.interfaces.services.DepositoService;

@Controller
public class HomeController {

	private DepositoService depositoService;
	
	@Autowired
	public HomeController(DepositoService depositoService) {
		super();
		this.depositoService = depositoService;
	}


	@RequestMapping(path="/")
	public ModelAndView index(){
		ModelAndView view = new ModelAndView("index");
		view.addObject("produtos", depositoService.listarProdutosDisponiveis());
		return view;
	}
	
	@RequestMapping(path="/Produto/{id}")
	public ModelAndView visualizarProduto(@PathVariable("id") Integer id){
		ModelAndView view = new ModelAndView("produto/item");
		view.addObject("produto", depositoService.carregarProdutoPorId(id));
		return view;
	}
}
