package com.crud.accenture.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.crud.accenture.domain.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Integer>, JpaSpecificationExecutor<Cliente> {
	boolean existsById(int id);
	
}
