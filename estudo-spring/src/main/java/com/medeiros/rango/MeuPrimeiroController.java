package com.medeiros.rango;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.medeiros.rango.di.modelo.Cliente;
import com.medeiros.rango.service.AtivarClienteService;


@Controller
public class MeuPrimeiroController {
	
	private AtivarClienteService ativarClienteService;
	
	public MeuPrimeiroController(AtivarClienteService ativarClienteService) {
		this.ativarClienteService = ativarClienteService ;
		System.out.println("MeuPrimeiroController::" + ativarClienteService);
	}
	
	@GetMapping("/hello")
	@ResponseBody
	public String hello() {
		Cliente cliente = new Cliente("Mariana", "marizinha@gmail.com", "81999999999", false);
		ativarClienteService.ativarCliente(cliente, "Olá, Seu cadastro de sistema está ativo");
		return "Hello!";
	}

}
