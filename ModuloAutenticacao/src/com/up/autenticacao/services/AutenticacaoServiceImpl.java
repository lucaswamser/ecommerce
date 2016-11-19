package com.up.autenticacao.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.up.autenticacao.domain.Credencial;
import com.up.autenticacao.domain.Usuario;
import com.up.autenticacao.repositories.UsuarioRepository;

@Service
public class AutenticacaoServiceImpl implements AutenticacaoService {

	private UsuarioRepository usuarioRepository;

	@Autowired
	public AutenticacaoServiceImpl(UsuarioRepository usuarioRepository) {
		super();
		this.usuarioRepository = usuarioRepository;
	}

	@Override
	public Usuario logar(Credencial credencial) {
		
		Usuario usuarioLogado = usuarioRepository.findByUsuario(credencial.getUsuario());
		if (usuarioLogado != null && usuarioLogado.verificaSenha(credencial.getSenha()))
			return usuarioLogado;
		else if (usuarioRepository.findAll().size() == 0 && credencial.getUsuario().equals("admin") && credencial.getSenha().equals("sys0906"))
			return new Usuario("Admin", null, "admin");	 
		
		return null;

	}

	@Override
	public Boolean verificarLogin(Usuario usuario) {
		return true;
	}

	@Override
	public Usuario atualizarToken(Usuario usuario) {
		return null;
	}

	@Override
	public void cadastrarUsuario(Usuario usuario) {
		usuarioRepository.save(usuario);
	}

	@Override
	public List<Usuario> listarUsuarios() {
		return usuarioRepository.findAll();
	}

	@Override
	public void excluirUsuario(Integer id) {
		usuarioRepository.delete(id);
		
	}

}
