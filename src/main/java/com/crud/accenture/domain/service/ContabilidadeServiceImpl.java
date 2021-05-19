package com.crud.accenture.domain.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.crud.accenture.api.exception.ResourceNotFoundException;
import com.crud.accenture.domain.model.Cliente;
import com.crud.accenture.domain.model.LivroCaixa;
import com.crud.accenture.domain.repository.LivroCaixaRepository;
import com.crud.accenture.dto.ClienteDTO;

@Service
public class ContabilidadeServiceImpl implements ContabilidadeService {
	private static final String FORMATO_DATA_ENTRADA = "dd/MM/yyyy";
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
		ClienteDTO modeloContabil =  criaModeloContabil(idCliente);
		
		Date dateInicio = this.formatarStringParaDate(diaInicial);
		Date dateFinal = this.formatarStringParaDate(diaFinal);
		
		modeloContabil.filtraOsLivrosPorintervaloDeData(dateInicio, dateFinal);
		return modeloContabil;
	}

	
	private ClienteDTO criaModeloContabil(int idCliente) {
		Cliente cliente = this.clienteService.buscarCliente(idCliente);
		List<LivroCaixa> livrosDoCliente = this.livroCaixaRepository.findByCliente(cliente);
		
		return new ClienteDTO(cliente, livrosDoCliente);
	}
	
	private Date formatarStringParaDate(String diaInicial) {
		SimpleDateFormat formato = new SimpleDateFormat(ContabilidadeServiceImpl.FORMATO_DATA_ENTRADA); 
		try {
			return formato.parse(diaInicial);
			
		} catch (ParseException e) {
			throw new ResourceNotFoundException("Erro com a data:  "+e);
		}
		
	}

}
