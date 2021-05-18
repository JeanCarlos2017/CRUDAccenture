package com.crud.accenture.domain.service;

import java.util.List;

import com.crud.accenture.domain.model.Cliente;

public interface ClienteService {
	Cliente cadastroCliente(Cliente cliente);
	
	Cliente alteraCliente(Cliente cliente);
	
	void deletaCliente(int idCliente);
	
	Cliente buscaCliente(int idCliente);
	
	List<Cliente> filtroDeCliente(String nome, String cpfCnpj, String cidade, String uf);
}
