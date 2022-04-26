package com.medeiros.rango.di.notificador;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.medeiros.rango.di.modelo.Cliente;

@TipoDeNotificador(NivelUrgencia.URGENTE)
@Component
public class NotificadorSMS implements Notificador{
	public NotificadorSMS() {
		System.out.println("NotificadorSMS");
	}

	@Override
	public void notificar(Cliente cliente, String msg) {
		System.out.printf("Enviando notificacao por SMS para %s no telefone: %s ", cliente.getNome(), cliente.getTelefone());
		
	}

}
