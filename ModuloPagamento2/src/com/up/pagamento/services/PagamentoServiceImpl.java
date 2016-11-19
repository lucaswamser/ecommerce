package com.up.pagamento.services;

import java.util.Date;
import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.up.pagamento.dao.PagamentoDao;
import com.up.pagamento.dao.PagamentoDaoImpl;
import com.up.pagamento.domain.Pagamento;

public class PagamentoServiceImpl implements PagamentoService {


	PagamentoDao pagamentoDao;
	

	public PagamentoServiceImpl(PagamentoDao pagamentoDao) {
		super();
		this.pagamentoDao = pagamentoDao;
	}


	@Override
	public Boolean pagar(Pagamento pagamento) {
	    pagamento.setIdPagamento(null);
	    pagamento.setData(new Date());
		System.out.println("pagamento valor" +pagamento.getValorPagamento());
		if(pagamento.getCartaoDeCredito().getCcv() == 420){
			pagamento.setAceito(false);
			pagamentoDao.adicionar(pagamento);
			return false;
		}
		else{
		pagamento.setAceito(true);
		pagamentoDao.adicionar(pagamento);
		return true;
		}
	}


	@Override
	public List<Pagamento> listar() {
		return pagamentoDao.listar();
	}

}
