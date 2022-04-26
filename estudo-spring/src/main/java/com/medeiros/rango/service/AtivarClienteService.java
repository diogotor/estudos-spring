package com.medeiros.rango.service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

import com.medeiros.rango.di.modelo.Cliente;


@Component
public class AtivarClienteService {
	
	@Autowired
	private ApplicationEventPublisher applicationEventPublisher;
	
	@PostConstruct
	public void init() {
		System.out.println("INIT");
	}
	
	@PreDestroy
	public void destroy() {
		System.out.println("DESTROY");
	}
	
	public AtivarClienteService() {
		System.out.println("AtivaClienteService: ");
	}



	public void ativarCliente(Cliente cliente, String msg) {
		cliente.ativar();
		applicationEventPublisher.publishEvent(new ClienteAtivadoEvent(cliente));
				
		
		
	}
}
