package com.crud.accenture.domain.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.crud.accenture.domain.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer>{
	
	boolean existsById(int id);
	
	Optional<Usuario> findByLoginAndSenha(String nome, String senha);
}
