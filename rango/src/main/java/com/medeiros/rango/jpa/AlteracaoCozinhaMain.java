package com.medeiros.rango.jpa;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

import com.medeiros.rango.RangoApplication;
import com.medeiros.rango.domain.model.Cozinha;
import com.medeiros.rango.infrastructure.repository.CozinhaRepositoryImpl;

import lombok.ToString;



public class AlteracaoCozinhaMain {
	
	public static void main(String[] args) {
		
		ApplicationContext applicationContext = new SpringApplicationBuilder(RangoApplication.class)
				.web(WebApplicationType.NONE)
				.run(args);
		CozinhaRepositoryImpl cozinhas = applicationContext.getBean(CozinhaRepositoryImpl.class);
		
		Cozinha cozinha = new Cozinha();
		cozinha.setId(1L);
		cozinha.setNome("Mexicana");
		cozinha = cozinhas.salvar(cozinha);
		
		System.out.printf("%d - %s\n", cozinha.getId(), cozinha.getNome());
		
	}

}
