package com.crud.accenture.api;

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
import org.springframework.web.bind.annotation.RestController;

import com.crud.accenture.domain.model.Cliente;
import com.crud.accenture.domain.service.ClienteService;

@RestController
@RequestMapping("/cliente")
public class ClienteController {
	private ClienteService clienteService;

	public ClienteController(ClienteService clienteService) {
		super();
		this.clienteService = clienteService;
	}
	
	@GetMapping("findById/{id_cliente}")
	public ResponseEntity<Cliente> buscarClientePorId(@PathVariable int id_cliente){
		return new ResponseEntity<Cliente>(this.clienteService.buscarCliente(id_cliente), HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<Cliente> cadastrarCliente(@Valid @RequestBody Cliente cliente){
		return new ResponseEntity<Cliente>(this.clienteService.cadastrarCliente(cliente), HttpStatus.CREATED);
	}
	
	@PutMapping
	public ResponseEntity<Cliente> alterarCliente(@Valid @RequestBody Cliente cliente){
		return new ResponseEntity<Cliente>(this.clienteService.alterarCliente(cliente), HttpStatus.ACCEPTED);
	}
	
	@DeleteMapping("{id_cliente}")
	public ResponseEntity<Void> deletarClientePorId(@PathVariable int id_cliente){
		this.clienteService.deletarCliente(id_cliente);
		return ResponseEntity.noContent().build();
	}
}
