package com.medeiros.rango.listener;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import com.medeiros.rango.di.modelo.Cliente;
import com.medeiros.rango.di.notificador.NivelUrgencia;
import com.medeiros.rango.di.notificador.Notificador;
import com.medeiros.rango.di.notificador.TipoDeNotificador;
import com.medeiros.rango.service.ClienteAtivadoEvent;

@Component
public class NotificacaoService {

	@TipoDeNotificador(NivelUrgencia.SEM_URGENCIA)
	@Autowired
	private Notificador notificador;
	
	@EventListener
	public void clienteAtivadoListener(ClienteAtivadoEvent clienteAtivadoEvent){
		Cliente cliente = clienteAtivadoEvent.getCliente();
		notificador.notificar(cliente, "Seu cadastro de sistema está ativo.");	
		
	}
}
