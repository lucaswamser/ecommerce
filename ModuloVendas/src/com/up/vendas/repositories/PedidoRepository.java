package com.up.vendas.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.up.vendas.domain.Pedido;

public interface PedidoRepository extends JpaRepository<Pedido, Integer> {

	List<Pedido> findByIdUsuario(Integer idUsuario);
}
