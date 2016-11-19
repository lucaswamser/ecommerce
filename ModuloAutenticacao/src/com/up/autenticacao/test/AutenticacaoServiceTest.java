package com.up.autenticacao.test;
import static org.junit.Assert.*;

import org.junit.Before;

import com.mmnaseri.utils.spring.data.dsl.factory.RepositoryFactoryBuilder;
import com.up.autenticacao.domain.Credencial;
import com.up.autenticacao.domain.Usuario;
import com.up.autenticacao.repositories.UsuarioRepository;
import com.up.autenticacao.services.AutenticacaoService;
import com.up.autenticacao.services.AutenticacaoServiceImpl;



public class AutenticacaoServiceTest {

	
	private AutenticacaoService autenticacaoService;
	private UsuarioRepository usuarioRepository;
	
	@Before
	public void setUp() throws Exception {
		usuarioRepository = RepositoryFactoryBuilder.builder().mock(
				UsuarioRepository.class);
		autenticacaoService = new AutenticacaoServiceImpl(usuarioRepository);
	}
	@org.junit.Test
	public void testCadastroUsuario() {
		autenticacaoService.cadastrarUsuario(new Usuario("Test", new Credencial("teste", "teste"), "administrador"));
		assertTrue(usuarioRepository.findAll().size() != 0);
	}
	

}
