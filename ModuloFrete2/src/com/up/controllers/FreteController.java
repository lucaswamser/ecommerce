package com.up.controllers;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.up.domain.Destinatario;
import com.up.domain.Frete;
import com.up.domain.Usuario;
import com.up.interfaces.services.FreteService;

@Controller
public class FreteController {

	private FreteService freteService;
	
	@Autowired
	public FreteController(FreteService freteService) {
		super();
		this.freteService = freteService;
	}

	@RequestMapping(path="/",method=RequestMethod.GET)
	public ModelAndView index(){
		ModelAndView view = new ModelAndView("frete/index");
		view.addObject("fretes", freteService.listar());
		return view;
	}
	
	
}
