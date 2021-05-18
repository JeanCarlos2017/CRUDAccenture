package com.crud.accenture.domain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.crud.accenture.domain.model.Cliente;
import com.crud.accenture.domain.model.LivroCaixa;

public interface LivroCaixaRepository extends JpaRepository<LivroCaixa, Integer>{
	boolean existsById(int id);
	
	List<LivroCaixa> findByCliente(Cliente cliente);
}
