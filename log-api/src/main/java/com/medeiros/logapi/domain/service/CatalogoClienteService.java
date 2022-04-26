package com.medeiros.logapi.domain.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.medeiros.logapi.domain.exception.NegocioException;
import com.medeiros.logapi.domain.model.Cliente;
import com.medeiros.logapi.domain.repository.ClienteRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CatalogoClienteService {
	private ClienteRepository clienteRepository;
	
	public Cliente buscar(Long id) {
		return clienteRepository.findById(id)
				.orElseThrow(() -> new NegocioException("Cliente não encontrado"));
	}
	
	@Transactional
	public Cliente salvar(Cliente cliente) {
		boolean emailEmUso = clienteRepository.findByEmail(cliente.getEmail())
				.stream()
				.anyMatch(clienteEmailExistente -> !clienteEmailExistente.equals(cliente));
		if(emailEmUso) {
			throw new NegocioException("Já existe um cliente cadastrado para esse e-mail");
		}
		return clienteRepository.save(cliente);
	}
	
	@Transactional
	public void remover(Long clienteId) {
		clienteRepository.deleteById(clienteId);
	}
}
