package com.up.estoque.services;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.up.estoque.domain.Credencial;
import com.up.estoque.domain.Usuario;
import com.up.estoque.exceptions.LoginInvalidoException;
import com.up.estoque.interfaces.services.AutenticacaoService;

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
		if(!usuarioLogado.getPerfil().equals("administrador"))
			throw new LoginInvalidoException("Perfil inválido para acesso a esse sistema");
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
	

}
