package com.up.autenticacao.interceptors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class AutorizadorInterceptor extends HandlerInterceptorAdapter {

	  @Override
	  public boolean preHandle(HttpServletRequest request, HttpServletResponse response,Object controller) throws Exception {
	    String uri = request.getRequestURI();
	    if (uri.endsWith("/Login") || uri.contains("plugin"))
	    	return true;
	    if (uri.contains("rest"))
	    	return true;
	  	if(request.getSession().getAttribute("usuarioLogado") != null)
	        return true;
	    response.sendRedirect(request.getContextPath()+"/Login");
	    return false;  
	  
	  }
	  
	
	}