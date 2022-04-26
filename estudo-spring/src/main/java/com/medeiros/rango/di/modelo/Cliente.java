package com.medeiros.rango.di.modelo;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Cliente {
	private String nome;
	private String email;
	private String telefone;
	private boolean ativo = false;
	
	
	public void ativar() {
		this.ativo = true;		
	}


}
