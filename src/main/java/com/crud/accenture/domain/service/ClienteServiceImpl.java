package com.crud.accenture.domain.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.crud.accenture.api.exception.ResourceNotFoundException;
import com.crud.accenture.domain.model.Cliente;
import com.crud.accenture.domain.repository.ClienteRepository;

@Service
public class ClienteServiceImpl implements ClienteService{
	private ClienteRepository clienteRepository;
	
	public ClienteServiceImpl(ClienteRepository clienteRepository) {
		this.clienteRepository = clienteRepository;
	}

	@Override
	public Cliente cadastroCliente(Cliente cliente) {
		return this.cadastroCliente(cliente);
	}

	@Override
	public Cliente alteraCliente(Cliente cliente) {
		if(this.clienteRepository.existsById(cliente.getId())) {
			return this.clienteRepository.save(cliente);
		}else {
			return this.throwIdNotFound();
		}
	}
	
	private Cliente throwIdNotFound() {
		throw new ResourceNotFoundException("Id do cliente não  encontrado, por favor tente novamente");
	}
	
	@Override
	public Cliente buscaCliente(int idCliente) {
		Optional<Cliente> clienteById= this.clienteRepository.findById(idCliente);
		if(clienteById.isPresent()) {
			return clienteById.get();
		}else {
			return this.throwIdNotFound();
		}
	}
	
	@Override
	public void deletaCliente(int idCliente) {
		if(this.clienteRepository.existsById(idCliente)) {
			this.clienteRepository.deleteById(idCliente);
		}else {
			this.throwIdNotFound();
		}
	}

	@Override
	public List<Cliente> filtroDeCliente(String nome, String cpfCnpj, String cidade, String uf) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
