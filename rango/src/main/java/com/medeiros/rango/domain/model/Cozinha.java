package com.medeiros.rango.domain.model;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class Cozinha {

	@EqualsAndHashCode.Include
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	
	private String nome;
	
	private BigDecimal taxaFrete;
	
	
	public static void main(String[] args) {
		Cozinha c = new Cozinha();
		c.setId(1L);
		c.setNome("Diogo");
		System.out.println(c.toString());
	}
	
	 
}
