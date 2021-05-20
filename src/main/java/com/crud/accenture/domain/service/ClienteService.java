package com.crud.accenture.domain.service;

import java.util.List;

import com.crud.accenture.domain.model.Cliente;

public interface ClienteService {
	Cliente cadastrarCliente(Cliente cliente);
	
	Cliente alterarCliente(Cliente cliente);
	
	void deletarCliente(int idCliente);
	
	Cliente buscarCliente(int idCliente);
	
	List<Cliente> filtrarCliente(String nome, String cpfCnpj, String cidade, String uf);

	List<Cliente> filtrarClienteComSpecification(String nome, String cpfCnpj, String cidade, String uf);
}
