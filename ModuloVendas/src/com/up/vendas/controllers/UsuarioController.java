package com.up.vendas.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.up.vendas.domain.Credencial;
import com.up.vendas.domain.Usuario;
import com.up.vendas.exceptions.LoginInvalidoException;
import com.up.vendas.interfaces.services.AutenticacaoService;

@Controller
public class UsuarioController {
	@Autowired
	private AutenticacaoService autenticacaoService;

	@RequestMapping(path = "/Login", method = RequestMethod.GET)
	public ModelAndView login() {
		ModelAndView view = new ModelAndView("login");
		return view;
	}

	@RequestMapping(path = "/Login", method = RequestMethod.POST)
	public ModelAndView login(Credencial credencial, HttpSession session) {
		ModelAndView view = new ModelAndView("login");
		Usuario usuario;
		try {
			usuario = autenticacaoService.logar(credencial);
			session.setAttribute("usuarioLogado", usuario);
			return new ModelAndView("redirect:/");
		} catch (LoginInvalidoException e) {
			view.addObject("erro", e.getMessage());
			return view;
		}

	}

	@RequestMapping(path = "/Cadastro", method = RequestMethod.GET)
	public ModelAndView cadastro() {
		ModelAndView view = new ModelAndView("cadastro");
		view.addObject("usuario", new Usuario());
		return view;
	}
	
	@RequestMapping(path = "/Cadastro", method = RequestMethod.POST)
	public String cadastro(Usuario usuario,HttpSession session,BindingResult bind) throws LoginInvalidoException{
		autenticacaoService.cadastrar(usuario);
		if (!bind.hasErrors()){
		session.setAttribute("usuarioLogado", autenticacaoService.logar(usuario.getCredencial()));
		return "redirect:/";
		}
		return "cadastro";
	}

	@RequestMapping(path = "/Logout", method = RequestMethod.GET)
	public ModelAndView logout(HttpSession session) {
		session.removeAttribute("usuarioLogado");
		return new ModelAndView("redirect:/");
	}

}
