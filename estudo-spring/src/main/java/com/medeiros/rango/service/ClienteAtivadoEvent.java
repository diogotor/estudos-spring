package com.medeiros.rango.service;

import com.medeiros.rango.di.modelo.Cliente;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ClienteAtivadoEvent {

	private Cliente cliente;
}
