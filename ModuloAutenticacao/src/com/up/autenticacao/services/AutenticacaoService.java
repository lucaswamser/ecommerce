package com.up.autenticacao.services;

import java.util.List;

import com.up.autenticacao.domain.Credencial;
import com.up.autenticacao.domain.Usuario;

public interface AutenticacaoService {
	
	
	Usuario logar(Credencial credencial);
	Boolean verificarLogin(Usuario usuario);
	Usuario atualizarToken(Usuario usuario);
	void cadastrarUsuario(Usuario usuario);
	void excluirUsuario(Integer id);
	List<Usuario> listarUsuarios();
	

}
