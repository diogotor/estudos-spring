package com.medeiros.rango.jpa;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

import com.medeiros.rango.RangoApplication;
import com.medeiros.rango.domain.model.Cozinha;
import com.medeiros.rango.infrastructure.repository.CozinhaRepositoryImpl;

public class InclusaoCozinhaMain {
	
	public static void main(String[] args) {
		
		ApplicationContext applicationContext = new SpringApplicationBuilder(RangoApplication.class)
				.web(WebApplicationType.NONE)
				.run(args);
		CozinhaRepositoryImpl cozinhas = applicationContext.getBean(CozinhaRepositoryImpl.class);
		
		Cozinha cozinha1 = new Cozinha();
		cozinha1.setNome("Brasileira");
		cozinha1 = cozinhas.salvar(cozinha1);
		Cozinha cozinha2 = new Cozinha();
		cozinha2.setNome("Francesa");
		cozinha2 = cozinhas.salvar(cozinha2);
		System.out.printf("%d - %s\n", cozinha1.getId(), cozinha1.getNome());
		System.out.printf("%d - %s\n", cozinha2.getId(), cozinha2.getNome());
	}

}
