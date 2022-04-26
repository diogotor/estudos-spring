package com.medeiros.logapi.api.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.medeiros.logapi.api.assembler.EntregaAssembler;
import com.medeiros.logapi.api.model.EntregaModel;
import com.medeiros.logapi.api.model.input.EntregaInput;

import com.medeiros.logapi.domain.repository.EntregaRepository;
import com.medeiros.logapi.domain.service.EntregaService;
import com.medeiros.logapi.domain.service.SolicitacaoEntregaService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/entregas")
public class EntregaController {
	
	private EntregaRepository entregaRepository;
	private SolicitacaoEntregaService solicitacaoEntregaService;
	private EntregaAssembler entregaAssembler;
	private EntregaService entregaService;
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public EntregaModel solicitar(@Valid @RequestBody EntregaInput entregaInput) {
		return entregaAssembler.toModel(solicitacaoEntregaService.solicitar(entregaAssembler.toEntity(entregaInput)));
	}
	
	@GetMapping
	public List<EntregaModel> listar(){
		return entregaAssembler.toListModel(entregaRepository.findAll());
	}
	
	@GetMapping("/{entregaId}")
	public ResponseEntity<EntregaModel> buscar(@PathVariable Long entregaId) {
		return entregaRepository.findById(entregaId)
				.map(entrega -> {
					EntregaModel entregaModel = entregaAssembler.toModel(entrega);					
				return ResponseEntity.ok(entregaModel);
		}).orElse(ResponseEntity.notFound().build());		
		// Old return entregaRepository.findById(entregaId).map(entrega -> ResponseEntity.ok(entrega)).orElse(ResponseEntity.notFound().build());
	}
	
	@PutMapping("/{entregaId}/finalizar")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void finalizar(@PathVariable Long entregaId) {
		entregaService.finalizar(entregaId);
	}
	
}
