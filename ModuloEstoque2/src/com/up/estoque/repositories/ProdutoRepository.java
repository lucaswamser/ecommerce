package com.up.estoque.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.up.estoque.domain.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Integer> {

}
