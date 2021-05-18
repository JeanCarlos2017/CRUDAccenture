package com.crud.accenture.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.crud.accenture.domain.model.LivroCaixa;

public interface LivroCaixaRepository extends JpaRepository<LivroCaixa, Integer>{
	boolean existsById(int id);
}
