package com.up.vendas.services;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.up.vendas.domain.Credencial;
import com.up.vendas.domain.Usuario;
import com.up.vendas.exceptions.LoginInvalidoException;
import com.up.vendas.interfaces.services.AutenticacaoService;

@Service
public class AutenticacaoServiceProxy implements AutenticacaoService {

	@Override
	public Usuario logar(Credencial credencial) throws LoginInvalidoException
	{
		final String uri = "http://localhost:8080/ModuloAutenticacao/rest/Autenticacao/logar";
		RestTemplate template = new RestTemplate();
		Usuario usuarioLogado = template.postForObject(uri,credencial,Usuario.class);
		if(usuarioLogado == null)
			throw new LoginInvalidoException("Usuário ou senha inválidos");
		return usuarioLogado;
	}

	@Override
	public Boolean verificarLogin(Usuario usuario) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Usuario atualizarToken(Usuario usuario) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void cadastrar(Usuario usuario) {
		final String uri = "http://localhost:8080/ModuloAutenticacao/rest/Autenticacao/cadastrar";
		RestTemplate template = new RestTemplate();
		template.postForLocation(uri, usuario);
	}
	

}
