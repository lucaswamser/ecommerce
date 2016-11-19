package com.up.estoque.app;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

import com.up.estoque.converters.DepositoCustomEditorBinder;
import com.up.estoque.converters.ProdutoCustomEditorBinder;
import com.up.estoque.interceptors.AutorizadorInterceptor;
import com.up.estoque.interfaces.services.ProdutoService;
import com.up.estoque.services.ProdutoServiceImpl;


@Configuration
@EnableWebMvc //<mvc:annotation-driven />
@ComponentScan(basePackages = { "com.up.estoque.controllers","com.up.estoque.endpoints","com.up.estoque.converters","com.up.estoque.listeners" })
public class SpringWebConfig extends WebMvcConfigurerAdapter {

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/plugin/**")
                        .addResourceLocations("/plugin/");
	}
	
	@Bean
	public InternalResourceViewResolver viewResolver() {
		InternalResourceViewResolver viewResolver 
                         = new InternalResourceViewResolver();
		viewResolver.setViewClass(JstlView.class);
		viewResolver.setPrefix("/WEB-INF/view/");
		viewResolver.setSuffix(".jsp");
		return viewResolver;
	}
 
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(new AutorizadorInterceptor());
	}

	

	

}