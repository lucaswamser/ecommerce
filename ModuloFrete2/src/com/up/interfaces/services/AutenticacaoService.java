package com.up.interfaces.services;

import com.up.domain.Credencial;
import com.up.domain.Usuario;


public interface AutenticacaoService {

	Usuario logar(Credencial credencial);
	Boolean verificarLogin(Usuario usuario);
	Usuario atualizarToken(Usuario usuario);
	
}
