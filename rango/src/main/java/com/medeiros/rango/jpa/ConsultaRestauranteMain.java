package com.medeiros.rango.jpa;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

import com.medeiros.rango.RangoApplication;
import com.medeiros.rango.infrastructure.repository.RestauranteRepositoryImpl;

public class ConsultaRestauranteMain {

	public static void main(String[] args) {
		ApplicationContext applicationContext = new SpringApplicationBuilder(RangoApplication.class)
				.web(WebApplicationType.NONE)
				.run(args);
		RestauranteRepositoryImpl restaurante = applicationContext.getBean(RestauranteRepositoryImpl.class);
		restaurante.listar().forEach(c -> System.out.println(c.getNome()));
		
		//System.out.println(cadastroCozinha.buscar(1L).getNome());

	}
}
