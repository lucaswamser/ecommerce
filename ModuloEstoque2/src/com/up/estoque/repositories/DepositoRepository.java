package com.up.estoque.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.up.estoque.domain.Deposito;

public interface DepositoRepository extends JpaRepository<Deposito, Integer> {

}
