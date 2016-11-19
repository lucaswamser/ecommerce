package com.up.estoque.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.up.estoque.domain.Movimentacao;
import com.up.estoque.domain.Produto;
import com.up.estoque.domain.Usuario;

public interface MovimentacaoRepository extends JpaRepository<Movimentacao, Integer> {
	
	List<Movimentacao> findByProduto(Produto produto);

}
