package com.medeiros.rango.di.notificador;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import com.medeiros.rango.di.modelo.Cliente;

@Profile("dev")
@TipoDeNotificador(NivelUrgencia.SEM_URGENCIA)
@Component
public class NotificadorEmailMock implements Notificador{
		
	public NotificadorEmailMock() {
		System.out.println("NotificadoEmailMock");
		
	}
	
	@Override
	public void notificar(Cliente cliente, String msg) {
		System.out.printf("MOCK: simulando envio de email para %s. Msg: %s\n", cliente.getNome(), msg);		
	}

}
