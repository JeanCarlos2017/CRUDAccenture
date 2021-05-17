package com.crud.accenture.api;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.crud.accenture.domain.model.Usuario;
import com.crud.accenture.domain.repository.UsuarioCustomRepository;
import com.crud.accenture.domain.repository.UsuarioRepository;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {
	private UsuarioRepository usuarioRepository;
	private UsuarioCustomRepository usuarioCustomRepository;
	
	public UsuarioController(UsuarioRepository usuarioRepository, UsuarioCustomRepository usuarioCustomRepository) {
		this.usuarioRepository = usuarioRepository;
		this.usuarioCustomRepository = usuarioCustomRepository;
	}

	@PostMapping
	public ResponseEntity<Usuario> cadastraUsuario(@Valid @RequestBody Usuario usuario){
		return new ResponseEntity<Usuario>(this.usuarioRepository.save(usuario), HttpStatus.CREATED);
	}
	
	 @GetMapping("/filter/custom")
	    public List<Usuario> findPersonByCustom(
	            @RequestParam(value = "nome", required = false) String nome,
	            @RequestParam(value = "email", required = false) String email
	    ) {
	        return this.usuarioCustomRepository.findUsuario(nome, email)
	                .stream()
	               .collect(Collectors.toList());
	    }

	
}
