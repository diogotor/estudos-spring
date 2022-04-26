package com.medeiros.rango.listener;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import com.medeiros.rango.di.modelo.Cliente;
import com.medeiros.rango.service.ClienteAtivadoEvent;

@Component
public class EmitirNotaFiscalService {

	
	@EventListener
	public void clienteAtivadoListener(ClienteAtivadoEvent clienteAtivadoEvent){
		Cliente cliente = clienteAtivadoEvent.getCliente();
		System.out.println("Emitindo nota fiscal para " + cliente.getNome());	
		
	}
}
