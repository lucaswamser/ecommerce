package com.up.pagamento.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.up.pagamento.domain.Pagamento;

public class PagamentoDaoImpl implements PagamentoDao {

	EntityManagerFactory emf;
    EntityManager em;
    
    
	public PagamentoDaoImpl() {
		emf = Persistence.createEntityManagerFactory("jcg-JPA");
	    em = emf.createEntityManager();
	}

	@Override
	public void adicionar(Pagamento pagamento) {
		em.getTransaction().begin();
		em.persist(pagamento);
		em.getTransaction().commit();
		
	}

	@Override
	public List<Pagamento> listar() {
		return em.createQuery(
	            "SELECT p FROM Pagamento p").getResultList();
	}

}
