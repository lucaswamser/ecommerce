package com.up.vendas.listeners;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.up.vendas.interfaces.services.PedidoService;
import com.up.vendas.repositories.PedidoRepository;
@Component
public class AMQPListener implements MessageListener  {

	@Override
	public void onMessage(Message arg0) {
		String mensagem = new String(arg0.getBody());
			System.out.println(mensagem);
	}

}
