package com.up.estoque.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.up.estoque.domain.Fornecedor;
import com.up.estoque.interfaces.services.FornecedorService;

@Controller
@RequestMapping(path = "/Fornecedor")
public class FornecedorController {
	
	private FornecedorService fornecedorService;
	
	@Autowired
	public FornecedorController(FornecedorService fornecedorService) {
		super();
		this.fornecedorService = fornecedorService;
	}
	
	@RequestMapping(path="/",method=RequestMethod.GET)
	public ModelAndView index(){
		ModelAndView view = new ModelAndView("fornecedor/index");
		view.addObject("fornecedores", fornecedorService.listar());
		return view;
	}
	
	@RequestMapping(path="/Adicionar",method=RequestMethod.GET)
	public ModelAndView adicionar(){
		ModelAndView view = new ModelAndView("fornecedor/form");
		view.addObject("fornecedor", new Fornecedor());
		return view;
	}
	
	@RequestMapping(path = "/Adicionar", method = RequestMethod.POST)
	public String cadastrar(@Valid Fornecedor fornecedor, BindingResult bind) {
		if (!bind.hasErrors()) {
			fornecedorService.adicionar(fornecedor);
			return "redirect:/Fornecedor/";
		}
		return "fornecedor/form";
	}
	
	@RequestMapping(path="/Atualizar/{id}",method=RequestMethod.GET)
	public ModelAndView atualizar(@PathVariable("id") Integer id){
		ModelAndView view = new ModelAndView("fornecedor/form");
		view.addObject("fornecedor", fornecedorService.carregarPorId(id));
		return view;
	}
	
	@RequestMapping(path = "/Atualizar/{id}", method = RequestMethod.POST)
	public String atualizar(@Valid Fornecedor fornecedor,BindingResult bind) {
		if (!bind.hasErrors()) {
			fornecedorService.atualizar(fornecedor);
			return "redirect:/Fornecedor/";
		}
		return "fornecedor/form";
	}
	
	@RequestMapping(path="/Remover/{id}",method=RequestMethod.GET)
	public String remover(@PathVariable("id") Integer id){
		fornecedorService.remover(id);
		return "redirect:/Fornecedor/";
	}
}
