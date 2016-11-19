package com.up.autenticacao.endpoints;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.up.autenticacao.domain.Credencial;
import com.up.autenticacao.domain.Usuario;
import com.up.autenticacao.services.AutenticacaoService;

@RestController
@RequestMapping(path="/rest/Autenticacao")
public class AutenticacaoEndPoint {

	@Autowired
	private AutenticacaoService autenticacaoService;
	
	@RequestMapping(path="/logar", method = RequestMethod.POST)
	private Usuario logar(@RequestBody Credencial credencial){
		return autenticacaoService.logar(credencial);
		
	}
	
	@RequestMapping(path="/cadastrar", method= RequestMethod.POST)
	private void cadastrar(@RequestBody Usuario usuario){
		usuario.setPerfil("usuario");
		autenticacaoService.cadastrarUsuario(usuario);
	}
	
	
	
}
