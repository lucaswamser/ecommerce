package com.up.vendas.strategies.notafiscal;

import java.text.Normalizer;
import java.util.regex.Pattern;

import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.google.gson.Gson;
import com.up.vendas.domain.NotaFiscal;

@Component
public class EmissorNotaFiscalModulo2 implements EmissorNotaFiscal{

	public static String value = "À Á Â Ã Ä Å Æ Ç È É Ê Ë Ì Í Î Ï Ð Ñ Ò Ó Ô Õ Ö Ø Ù Ú Û Ü Ý Þ ß à á â ã ä å æ ç è é ê ë ì í î ï ð ñ ò ó ô õ ö ø ù ú û ü ý þ ÿ ";

    
    public  String semAcento(String str) {
        String nfdNormalizedString = Normalizer.normalize(str, Normalizer.Form.NFD); 
        Pattern pattern = Pattern.compile("\\p{InCombiningDiacriticalMarks}+");
        return pattern.matcher(nfdNormalizedString).replaceAll("");
    }
	
	@Override
	public void emitir(NotaFiscal nfe) {
		CachingConnectionFactory connectionFactory = new CachingConnectionFactory("localhost");
		connectionFactory.setHost("192.168.132.200");
		connectionFactory.setPort(5672);
		connectionFactory.setUsername("Nfe");
		connectionFactory.setPassword("12345");
		RabbitTemplate template = new RabbitTemplate(connectionFactory);
		template.setRoutingKey("Nfe");
		System.out.println(semAcento(nfe.toJson()));
		template.convertAndSend(semAcento(nfe.toJson()));
	}

}
