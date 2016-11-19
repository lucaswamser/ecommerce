/**
 * PagamentoService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.up.vendas.interfaces.services;

import com.up.vendas.domain.Pagamento;
import com.up.vendas.exceptions.PagNaoAprovadoException;

public interface PagamentoService extends java.rmi.Remote {
    public boolean pagar(Pagamento arg0) throws java.rmi.RemoteException , PagNaoAprovadoException;
}
