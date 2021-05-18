package com.crud.accenture.domain.service;

import java.util.List;

import com.crud.accenture.domain.model.LivroCaixa;
import com.crud.accenture.dto.ClienteDTO;

public interface ContabilidadeService {
	List<LivroCaixa> findByIdCliente(int idCliente);
	
	ClienteDTO getStatementCliente(int idCliente, String diaInicial, String diaFinal);
}
