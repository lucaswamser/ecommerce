package com.up.vendas.app;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.up.vendas.strategies.notafiscal.EmissorNotaFiscal;
import com.up.vendas.strategies.notafiscal.EmissorNotaFiscalModulo1;
import com.up.vendas.strategies.notafiscal.EmissorNotaFiscalModulo2;
@Configuration
@ComponentScan({ "com.up.vendas.services" })
public class SpringRootConfig {
	
	@Bean
	public EmissorNotaFiscal emissorNotaFiscal() {
		return new EmissorNotaFiscalModulo1();
	}
	
}