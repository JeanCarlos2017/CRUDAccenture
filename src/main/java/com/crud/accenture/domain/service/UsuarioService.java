package com.crud.accenture.domain.service;

import java.util.List;

import com.crud.accenture.domain.model.Usuario;

public interface UsuarioService {
	Usuario cadastraUsuario(Usuario usuario);
	
	Usuario alteraUsuario(Usuario usuario);
	
	boolean deletaUsuario(int idusuario);
	
	Usuario buscausuario(int idUsuario);
	
	List<Usuario> filtro(String nome, String email);
	
	Usuario login(Usuario usuario);
}
