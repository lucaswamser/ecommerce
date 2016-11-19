package com.up.pagamento.endpoint;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;

import com.up.pagamento.domain.Pagamento;

@WebService
@SOAPBinding(style = Style.RPC)
public interface PagamentoEndPoint {
	
	Boolean pagar(Pagamento pagamento);


}
