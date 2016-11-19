package com.up.estoque.listeners;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.up.estoque.domain.MovimentacaoSaida;
import com.up.estoque.interfaces.services.DepositoService;
import com.up.estoque.repositories.ProdutoRepository;
@Component
public class AMQPListener implements MessageListener  {

	@Autowired
	private DepositoService depositoService;
	@Autowired
	private ProdutoRepository produtoRepository;
	@Override
	public void onMessage(Message arg0) {
		String mensagem = new String(arg0.getBody());
		System.out.println("mensagem recebida no modulo de estoque: "+mensagem);
		if (mensagem.startsWith("ordemsaida")){
		 String[] valores = mensagem.split(",");
		 tirarEstoque(Integer.valueOf(valores[1]),Integer.valueOf(valores[2]));
		}
	}
	
	public void tirarEstoque(Integer quantidade, Integer idProduto){
		MovimentacaoSaida ms = new MovimentacaoSaida();
		ms.setProduto(produtoRepository.findOne(idProduto));
		ms.setQuantidade(quantidade);
		depositoService.movimentar(ms);

	}

}
