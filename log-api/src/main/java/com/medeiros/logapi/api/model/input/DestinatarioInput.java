package com.medeiros.logapi.api.model.input;

import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DestinatarioInput {
	
	
	@NotNull
	private String nome;
	
	@NotNull
	private String logradouro;
		
	@NotNull
	private Integer numero;
	
	private String complemento;
	
	@NotNull
	private String bairro;

}
