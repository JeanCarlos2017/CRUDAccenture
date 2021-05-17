package com.crud.accenture.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.crud.accenture.domain.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer>{
	
	
}
