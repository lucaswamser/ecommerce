package com.up.vendas.services;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.up.vendas.domain.NotaFiscal;
import com.up.vendas.interfaces.services.NotaFiscalService;
import com.up.vendas.strategies.notafiscal.EmissorNotaFiscal;
@Service

public class NotaFiscalServiceImpl implements NotaFiscalService {

	@Autowired
	EmissorNotaFiscal emissor;
	
	@Override
	public void enviarNota(NotaFiscal nfe) {
			emissor.emitir(nfe);
	}

}
