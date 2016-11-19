package com.up.vendas.interfaces.services;

import com.up.vendas.domain.Credencial;
import com.up.vendas.domain.Usuario;
import com.up.vendas.exceptions.LoginInvalidoException;


public interface AutenticacaoService {

	Usuario logar(Credencial credencial) throws LoginInvalidoException;
	void cadastrar(Usuario usuario);
	Boolean verificarLogin(Usuario usuario);
	Usuario atualizarToken(Usuario usuario);
	
}
