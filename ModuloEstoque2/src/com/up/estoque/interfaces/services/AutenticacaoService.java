package com.up.estoque.interfaces.services;

import com.up.estoque.domain.Credencial;
import com.up.estoque.domain.Usuario;
import com.up.estoque.exceptions.LoginInvalidoException;


public interface AutenticacaoService {

	Usuario logar(Credencial credencial) throws LoginInvalidoException;
	Boolean verificarLogin(Usuario usuario);
	Usuario atualizarToken(Usuario usuario);
	
}
