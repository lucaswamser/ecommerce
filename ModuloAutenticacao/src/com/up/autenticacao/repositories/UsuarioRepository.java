package com.up.autenticacao.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.up.autenticacao.domain.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer>{
	
	@Query("select u from Usuario u where u.credencial.usuario = :usuario")
	Usuario findByUsuario(@Param("usuario") String usuario);

}
