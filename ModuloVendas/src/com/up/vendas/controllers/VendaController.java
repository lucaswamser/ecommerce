package com.up.vendas.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.up.vendas.domain.Destinatario;
import com.up.vendas.domain.Frete;
import com.up.vendas.domain.Pedido;
import com.up.vendas.domain.Usuario;
import com.up.vendas.exceptions.PagNaoAprovadoException;
import com.up.vendas.interfaces.services.PedidoService;

@Service
@RequestMapping("/Venda")
public class VendaController {

	private PedidoService pedidoService;
	

	@Autowired
	public VendaController(PedidoService pedidoService) {
		super();
		this.pedidoService = pedidoService;
	}

	
	@RequestMapping(path = "/CheckOut")
	public ModelAndView checkOut(HttpServletRequest request) {
		ModelAndView view = new ModelAndView("pedido/checkout");
		Pedido pedido = (Pedido) request.getSession().getAttribute("carrinho");
		view.addObject("pedido", pedido);
		return view;
	}

	@RequestMapping(path = "/CheckOut", method = RequestMethod.POST)
	public String checkOut(@Valid Pedido pedido, HttpServletRequest request,
			BindingResult bind) {
		if (!bind.hasErrors()) {
			Pedido carrinho = (Pedido) request.getSession().getAttribute(
					"carrinho");
			pedido.setProdutos(carrinho.getProdutos());
			pedido.setTotal(carrinho.getTotal());
			Usuario usuario = ((Usuario) request.getSession().getAttribute(
					"usuarioLogado"));
			
			pedido.getFrete().setPeso(carrinho.getFrete().getPeso());
			pedido.getFrete().getDestinatario().setEmail(usuario.getEmail());
			pedido.setIdUsuario(usuario.getIdUsuario());
			request.getSession().setAttribute("carrinho", pedido);
			try {
				pedidoService.pedir(pedido);
				request.getSession().removeAttribute("carrinho");
				return "pedido/pedidook";
			} catch (PagNaoAprovadoException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return "pedido/pagnaoaprovado";
			}
		}
		return "pedido/checkout";

	}

}
