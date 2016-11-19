package com.up.estoque.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.up.estoque.domain.Fornecedor;
import com.up.estoque.domain.Produto;

public interface FornecedorRepository extends JpaRepository<Fornecedor, Integer> {

}
