package com.up.pagamento.testes;

import java.util.Date;

import junit.framework.TestCase;

import org.junit.Test;

import com.up.pagamento.dao.PagamentoDao;
import com.up.pagamento.domain.CartaoDeCredito;
import com.up.pagamento.domain.Pagamento;
import com.up.pagamento.services.PagamentoService;
import com.up.pagamento.services.PagamentoServiceImpl;

import static org.mockito.Mockito.*;


public class PagamentoServiceTest extends TestCase {
	
	public void testRealizarPagamentoAprovado(){
		PagamentoService pg =  new PagamentoServiceImpl(mock(PagamentoDao.class));
		Pagamento pag = new Pagamento();
		pag.setValorPagamento(10.40);
		pag.setData(new Date());
		pag.setCartaoDeCredito(new CartaoDeCredito("555543342324", 325, "22/12/2016", "10/11/2016"));
		assertTrue(pg.pagar(pag));
	}
	
	public void testRealizarPagamentoReprovado(){
		PagamentoService pg =  new PagamentoServiceImpl(mock(PagamentoDao.class));
		Pagamento pag = new Pagamento();
		pag.setValorPagamento(10.40);
		pag.setData(new Date());
		pag.setCartaoDeCredito(new CartaoDeCredito("555543342324", 420, "22/12/2016", "10/11/2016"));
		assertFalse(pg.pagar(pag));
	}

}
