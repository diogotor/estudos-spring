package com.medeiros.logapi.domain.service;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.medeiros.logapi.domain.exception.NegocioException;
import com.medeiros.logapi.domain.model.Entrega;
import com.medeiros.logapi.domain.repository.EntregaRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class EntregaService {
	private EntregaRepository entregaRepository;
	
	@Transactional
	public void finalizar(Long entregaId) {
		Entrega entrega = buscar(entregaId);
		entrega.finalizar();
		
		entregaRepository.save(entrega);
	}
	
	public Entrega buscar(Long entregaId) {
		return entregaRepository.findById(entregaId)
				.orElseThrow(() ->new NegocioException("Entrega não encontrada"));
	}
}
