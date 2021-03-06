package com.crud.accenture.domain.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.crud.accenture.api.exception.ResourceNotFoundException;
import com.crud.accenture.domain.model.Usuario;
import com.crud.accenture.domain.repository.UsuarioCustomRepository;
import com.crud.accenture.domain.repository.UsuarioRepository;

@Service @Transactional
public class UsuarioServiceImpl implements UsuarioService{
	
	private UsuarioRepository usuarioRepository;
	private UsuarioCustomRepository customRepository;
	
	public UsuarioServiceImpl(UsuarioRepository usuarioRepository, UsuarioCustomRepository customRepository) {
		super();
		this.usuarioRepository = usuarioRepository;
		this.customRepository = customRepository;
	}

	@Override
	public Usuario cadastraUsuario(Usuario usuario) {
		return this.usuarioRepository.save(usuario);
	}

	@Override
	public Usuario alteraUsuario(Usuario usuario) {
		if (this.usuarioRepository.existsById(usuario.getId())) {
			return this.usuarioRepository.save(usuario);
		}else {
			return this.throwIdNotFound();
		}
	}

	@Override
	public void deletaUsuario(int idUsuario) {
		if (this.usuarioRepository.existsById(idUsuario)) {
			this.usuarioRepository.deleteById(idUsuario);
		}else {
			this.throwIdNotFound();
		}
	}

	@Override
	public Usuario buscaUsuario(int idUsuario) {
		if(this.usuarioRepository.existsById(idUsuario)) {
			return this.usuarioRepository.findById(idUsuario).get();
		}else {
			return this.throwIdNotFound();
		}
	}

	@Override
	public List<Usuario> filtrarUsuarioPorNomeEOuEmail(String nome, String email) {
		return this.customRepository.findUsuario(nome, email);
	}

	@Override
	public String login(String login, String senha) {
		Optional<Usuario> loginUsuario= this.loginUsuario(login, senha);
		return this.verificaSucessoLogin(loginUsuario);
	}
	
	private Optional<Usuario> loginUsuario(String login, String senha) {
		return this.usuarioRepository.findByLoginAndSenha(login, senha);
	}
	
	private String verificaSucessoLogin(Optional<Usuario> loginUsuario) {
		if(loginUsuario.isPresent()) {
			return verificaUsuarioAtivo(loginUsuario.get());
		}else {
			return "Login e/ou senha incorreto";
		}
	}

	private String verificaUsuarioAtivo(Usuario usuario) {
		if(usuario.isAtivo()) {
			return "Usu??rio logado com sucesso";
		}else {
			return "Usu??rio est?? inativo por favor entre em contato com a central!";
		}
	}

	private Usuario throwIdNotFound() {
		throw new ResourceNotFoundException("Id do usu??rio n??o  encontrado, por favor tente novamente");
	}

	@Override
	public List<Usuario> buscarTodosUsuarios() {
		return this.usuarioRepository.findAll();
	}
}
