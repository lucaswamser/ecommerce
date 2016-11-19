package com.up.vendas.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.up.vendas.domain.ProdutoDeposito;

public interface ProdutoDepositoRepository extends JpaRepository<ProdutoDeposito, Integer> {

}
