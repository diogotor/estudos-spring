package com.medeiros.rango.di.notificador;

import com.medeiros.rango.di.modelo.Cliente;

public interface Notificador {

	public void notificar(Cliente cliente, String msg);
}
