package com.medeiros.rango.jpa;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

import com.medeiros.rango.RangoApplication;
import com.medeiros.rango.infrastructure.repository.CozinhaRepositoryImpl;

public class ConsultaCozinhaMain {

	public static void main(String[] args) {
		ApplicationContext applicationContext = new SpringApplicationBuilder(RangoApplication.class)
				.web(WebApplicationType.NONE)
				.run(args);
		CozinhaRepositoryImpl cozinhas = applicationContext.getBean(CozinhaRepositoryImpl.class);
		cozinhas.listar().forEach(c -> System.out.println(c.getNome()));
		
		//System.out.println(cadastroCozinha.buscar(1L).getNome());

	}
}
