package com.up.pagamento.endpoint;

import javax.jws.WebMethod;
import javax.jws.WebService;

import com.up.pagamento.dao.PagamentoDaoImpl;
import com.up.pagamento.domain.Pagamento;
import com.up.pagamento.services.PagamentoService;
import com.up.pagamento.services.PagamentoServiceImpl;

@WebService(endpointInterface = "com.up.pagamento.endpoint.PagamentoEndPoint")
public class PagamentoEndPointImpl implements PagamentoEndPoint {

	private PagamentoService pagamentoService;
	
	

	public PagamentoEndPointImpl() {
		super();
		this.pagamentoService = new PagamentoServiceImpl(new PagamentoDaoImpl());
	}


	@WebMethod
	@Override
	public Boolean pagar(Pagamento pagamento) {
		System.out.println("modulo de pagamento recebeu a requisição");
		return pagamentoService.pagar(pagamento);
	}

}
