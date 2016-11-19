package com.up.vendas.services;

import java.rmi.RemoteException;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.up.vendas.domain.NotaFiscal;
import com.up.vendas.domain.Pedido;
import com.up.vendas.domain.Usuario;
import com.up.vendas.exceptions.PagNaoAprovadoException;
import com.up.vendas.interfaces.services.NotaFiscalService;
import com.up.vendas.interfaces.services.PagamentoService;
import com.up.vendas.interfaces.services.PedidoService;
import com.up.vendas.repositories.PedidoRepository;

@Service
public class PedidoServiceImpl implements PedidoService {

	private DepositoServiceProxy depositoService;
	private FreteServiceProxy freteService;
	private PedidoRepository pedidoRepository;
	private PagamentoService pagamentoService;
	private NotaFiscalService notaFiscalService;
	
	@Autowired
	public PedidoServiceImpl(DepositoServiceProxy depositoService,
			FreteServiceProxy freteService, PedidoRepository pedidoRepository,
			PagamentoService pagamentoService, NotaFiscalService notaFiscalService) {
		super();
		this.depositoService = depositoService;
		this.freteService = freteService;
		this.pedidoRepository = pedidoRepository;
		this.pagamentoService = pagamentoService;
		this.notaFiscalService = notaFiscalService;
	}

	@Override
	public void pedir(Pedido pedido) throws PagNaoAprovadoException {
		pedido.getPagamento().setValorPagamento(pedido.getTotal());
		pedido.setDate(new Date());
		try {
			pagamentoService.pagar(pedido.getPagamento());
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			throw new PagNaoAprovadoException("Operadora não disponivel");
		}
		pedido.getProdutos().stream().forEach(e -> depositoService.retirarProduto(e));
		System.out.println(pedido.getFrete().getDestinatario().getEmail());
		NotaFiscal notaFiscal = new NotaFiscal(pedido);
		notaFiscalService.enviarNota(notaFiscal);
		pedido.setFrete(freteService.contratar(pedido.getFrete()));
		pedido.setStatus("Pago");
		pedidoRepository.save(pedido);
	}

	@Override
	public List<Pedido> listarPedidosDoUsuario(Integer idUsuario) {
		return pedidoRepository.findByIdUsuario(idUsuario);
	}

	@Override
	public List<Pedido> listar() {
		// TODO Auto-generated method stub
		return null;
	}

}
