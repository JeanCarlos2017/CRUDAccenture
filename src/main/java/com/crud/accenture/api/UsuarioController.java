package com.crud.accenture.api;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.crud.accenture.domain.model.Usuario;
import com.crud.accenture.domain.service.UsuarioService;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {
	private UsuarioService usuarioService;
	
	public UsuarioController(UsuarioService usuarioService) {
		this.usuarioService = usuarioService;
	}

	@PostMapping
	public ResponseEntity<Usuario> cadastraUsuario(@Valid @RequestBody Usuario usuario) {
		return new ResponseEntity<Usuario>(this.usuarioService.cadastraUsuario(usuario), HttpStatus.CREATED);
	}

	@GetMapping("/filter/custom")
	public ResponseEntity<List<Usuario>> findPersonByCustom(@RequestParam(value = "nome", required = false) String nome,
			@RequestParam(value = "email", required = false) String email) {
		return new ResponseEntity<List<Usuario>>(
				this.usuarioService.filtrarUsuarioPorNomeEOuEmail(nome, email) 
				 .stream()
				 .collect(Collectors.toList()), HttpStatus.OK
		);
	}
	
	@GetMapping("/findById/{id_usuario}")
	public ResponseEntity<Usuario> cadastraUsuario(@Valid @PathVariable int id_usuario) {
		return new ResponseEntity<Usuario>(this.usuarioService.buscaUsuario(id_usuario), HttpStatus.OK);
	}
	
	@PutMapping
	public ResponseEntity<Usuario> alteraUsuario(@Valid @RequestBody Usuario usuario) {
		return new ResponseEntity<Usuario>(this.usuarioService.alteraUsuario(usuario), HttpStatus.ACCEPTED);
	}
	
	@DeleteMapping("/{id_usuario}")
	public ResponseEntity<Void> deleteUsuario(@Valid @PathVariable int id_usuario) {
		this.usuarioService.deletaUsuario(id_usuario);
		return ResponseEntity.noContent().build();
	}
	
	
	@GetMapping("/login")
	public ResponseEntity<Usuario> login(@RequestParam(value = "login", required = false) String login,
			@RequestParam(value = "senha", required = false) String senha) {
		return new ResponseEntity<Usuario>(this.usuarioService.login(login, senha), HttpStatus.OK);
	}
	
}
