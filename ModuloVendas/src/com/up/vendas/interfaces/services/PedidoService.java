package com.up.vendas.interfaces.services;

import java.util.List;

import com.up.vendas.domain.Pedido;
import com.up.vendas.domain.Usuario;
import com.up.vendas.exceptions.PagNaoAprovadoException;

public interface PedidoService {
	
	void pedir(Pedido pedido) throws PagNaoAprovadoException;
	List<Pedido> listarPedidosDoUsuario(Integer idUsuario);
	List<Pedido> listar();
	
	
}
