package com.up.vendas.strategies.notafiscal;

import com.up.vendas.domain.NotaFiscal;

public interface EmissorNotaFiscal {

	public void emitir(NotaFiscal notaFiscal);
}
