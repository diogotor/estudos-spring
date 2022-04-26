package com.medeiros.rango.di.notificador;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import com.medeiros.rango.di.modelo.Cliente;

@Profile("prod")
@TipoDeNotificador(NivelUrgencia.SEM_URGENCIA)
@Component
public class NotificadorEmail implements Notificador{
		
	public NotificadorEmail() {
		System.out.println("NotificadorEmail real");
	}
	
	@Override
	public void notificar(Cliente cliente, String msg) {
		System.out.printf("Enviando notificacao de email para %s. Msg: %s\n", cliente.getNome(), msg);		
	}

}
