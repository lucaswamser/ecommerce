package com.up.vendas.strategies.notafiscal;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.google.gson.Gson;
import com.up.vendas.domain.NotaFiscal;

@Component
public class EmissorNotaFiscalModulo1 implements EmissorNotaFiscal{

	@Autowired
	RabbitTemplate rabbitTemplateNota;
	
	@Override
	public void emitir(NotaFiscal nfe) {
		rabbitTemplateNota.setRoutingKey("nfe");
		Gson gson = new Gson();		
		String message = gson.toJson(nfe);
		rabbitTemplateNota.convertAndSend(message);
		System.out.println("mandando mensagem"+ message);
	}

}
