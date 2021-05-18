package com.crud.accenture.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.crud.accenture.domain.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {

}
