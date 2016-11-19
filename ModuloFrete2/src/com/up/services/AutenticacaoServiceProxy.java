package com.up.services;

import org.springframework.http.HttpEntity;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.up.domain.Credencial;
import com.up.domain.Usuario;
import com.up.interfaces.services.AutenticacaoService;

@Service
public class AutenticacaoServiceProxy implements AutenticacaoService {

	@Override
	public Usuario logar(Credencial credencial) {
		final String uri = "http://localhost:8080/ModuloAutenticacao/rest/Autenticacao/logar";
		RestTemplate template = new RestTemplate();
		Usuario usuarioLogado = template.postForObject(uri,credencial,Usuario.class);
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
