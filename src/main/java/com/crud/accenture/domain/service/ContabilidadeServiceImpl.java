package com.crud.accenture.domain.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.crud.accenture.domain.model.Cliente;
import com.crud.accenture.domain.model.LivroCaixa;
import com.crud.accenture.domain.repository.LivroCaixaRepository;
import com.crud.accenture.dto.ClienteDTO;

@Service
public class ContabilidadeServiceImpl implements ContabilidadeService {

	private LivroCaixaRepository livroCaixaRepository;
	private ClienteService clienteService;
	
	public ContabilidadeServiceImpl(LivroCaixaRepository livroCaixaRepository, ClienteService clienteService) {
		super();
		this.livroCaixaRepository = livroCaixaRepository;
		this.clienteService = clienteService;
	}

	@Override
	public List<LivroCaixa> findByIdCliente(int idCliente) {
		Cliente cliente= this.clienteService.buscarCliente(idCliente);
		return this.livroCaixaRepository.findByCliente(cliente);
	}

	@Override
	public ClienteDTO getStatementCliente(int idCliente, String diaInicial, String diaFinal) {
		//TODO incluir os filtros de datas
		Cliente cliente = this.clienteService.buscarCliente(idCliente);
		List<LivroCaixa> livrosDoCliente = this.livroCaixaRepository.findByCliente(cliente);
		
		return new ClienteDTO(cliente, livrosDoCliente);
	}

}