package com.up.vendas.controllers;


import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.up.vendas.domain.Usuario;
import com.up.vendas.interfaces.services.PedidoService;

@Controller
@RequestMapping("/Compras")
public class CompraController {

	private PedidoService pedidoService;
	
	@Autowired
	public CompraController(PedidoService pedidoService) {
		super();
		this.pedidoService = pedidoService;
	}

	@RequestMapping(path = "/")
	public ModelAndView comprasUsuario(HttpServletRequest request){
		ModelAndView view = new ModelAndView("pedido/compras");
		Usuario usuario = (Usuario) request.getSession().getAttribute("usuarioLogado");
		view.addObject("compras", pedidoService.listarPedidosDoUsuario(usuario.getIdUsuario()));
		return view;
	}
	
	
	

}
