package com.up.endpoints;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.up.domain.Frete;
import com.up.interfaces.services.FreteService;

@RestController
@RequestMapping("rest/Frete")
public class FreteEndPoint {
	
	
	@Autowired
	private FreteService freteService;
	
	@RequestMapping(path="/calcular",method=RequestMethod.POST)
	public Double calcular(@RequestBody Frete frete){
		return freteService.calcular(frete);
	}

	@RequestMapping(path="/contratar",method=RequestMethod.POST)
	public Frete contratar(@RequestBody Frete frete){
		return freteService.contratar(frete);
	}

}
