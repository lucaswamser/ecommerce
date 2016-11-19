package com.up.autenticacao.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.up.autenticacao.domain.Credencial;
import com.up.autenticacao.domain.Usuario;
import com.up.autenticacao.services.AutenticacaoService;

@Controller
public class UsuarioController {

	private AutenticacaoService autenticacaoService;

	@Autowired
	public UsuarioController(AutenticacaoService autenticacaoService) {
		super();
		this.autenticacaoService = autenticacaoService;
	}

	@RequestMapping(path = {"/","/Usuario"}, method = RequestMethod.GET)
	public ModelAndView index() {
		ModelAndView view = new ModelAndView("usuario/index");
		view.addObject("usuarios", autenticacaoService.listarUsuarios());
		return view;
	}

	@RequestMapping(path = "Usuario/Cadastro", method = RequestMethod.GET)
	public ModelAndView cadastrar() {
		ModelAndView view = new ModelAndView("usuario/form");
		view.addObject("usuario", new Usuario());
		return view;
	}

	@RequestMapping(path = "Usuario/Cadastro", method = RequestMethod.POST)
	public String cadastrar(@Valid Usuario usuario, BindingResult bind) {
		if (!bind.hasErrors()) {
			autenticacaoService.cadastrarUsuario(usuario);
			return "redirect:/";
		}
		return "usuario/form";
	}

	@RequestMapping(path="Usuario/Excluir/{id}",method=RequestMethod.GET)
	public String excluir (@PathVariable("id") Integer id){
		autenticacaoService.excluirUsuario(id);
		return "redirect:/Usuario/";
		
	}
	
	@RequestMapping(path = "/Login", method = RequestMethod.GET)
	public ModelAndView login() {
		ModelAndView view = new ModelAndView("login");
		return view;
	}

	
	@RequestMapping(path = "/Login", method = RequestMethod.POST)
	public ModelAndView login(Credencial credencial, HttpSession session) {
		ModelAndView view = new ModelAndView("login");
		Usuario usuario = autenticacaoService.logar(credencial);
		if (usuario != null) {
			session.setAttribute("usuarioLogado", usuario);
			return new ModelAndView("redirect:/");
		}
		return view;
	}

	@RequestMapping(path = "/Logout", method = RequestMethod.GET)
	public ModelAndView logout(HttpSession session) {
		session.removeAttribute("usuarioLogado");
		return new ModelAndView("redirect:/");
	}

}
