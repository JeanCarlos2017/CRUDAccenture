package com.crud.accenture.domain.service;

import java.util.List;

import com.crud.accenture.domain.model.Usuario;

public interface UsuarioService {
	Usuario cadastraUsuario(Usuario usuario);
	
	Usuario alteraUsuario(Usuario usuario);
	
	void deletaUsuario(int idUsuario);
	
	Usuario buscaUsuario(int idUsuario);
	
	List<Usuario> filtrarUsuarioPorNomeEOuEmail(String nome, String email);
	
	String login(String login, String senha);
}
