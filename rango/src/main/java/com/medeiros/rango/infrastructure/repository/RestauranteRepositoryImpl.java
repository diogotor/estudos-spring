package com.medeiros.rango.infrastructure.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Component;

import com.medeiros.rango.domain.model.Cozinha;
import com.medeiros.rango.domain.model.Restaurante;
import com.medeiros.rango.domain.repository.CozinhaRepository;
import com.medeiros.rango.domain.repository.RestauranteRepository;

@Component
public class RestauranteRepositoryImpl implements RestauranteRepository {

	@PersistenceContext
	private EntityManager manager;
	
	@Override
	public List<Restaurante> listar(){
		TypedQuery<Restaurante> typeQuery = manager.createQuery("from Restaurante", Restaurante.class);
		return typeQuery.getResultList();
	}
	
	@Override
	public Restaurante buscar(Long id) {
		return manager.find(Restaurante.class, id);
	}
	
	@Override
	@Transactional
	public Restaurante salvar(Restaurante restaurante) {
		return manager.merge(restaurante);
	}
	
	@Override
	@Transactional
	public void remover(Long id) {
		Restaurante restaurante = buscar(id);
		manager.remove(restaurante);
	}

}
