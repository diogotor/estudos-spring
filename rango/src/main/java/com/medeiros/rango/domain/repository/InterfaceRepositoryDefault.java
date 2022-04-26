package com.medeiros.rango.domain.repository;

import java.util.List;


public interface InterfaceRepositoryDefault<T> {

	List<T> listar();
	T buscar(Long id);
	T salvar(T entity);
	void remover(Long id);
}
