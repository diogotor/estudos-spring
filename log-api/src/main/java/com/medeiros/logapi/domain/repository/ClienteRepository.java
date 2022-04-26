package com.medeiros.logapi.domain.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.medeiros.logapi.domain.model.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long>{

	
	List<Cliente> findByNome(String nome);
	List<Cliente> findByEmailContaining(String txt);
	Optional<Cliente> findByEmail(String email);
}
