package com.crud.accenture.domain.service;

import java.util.Date;
import java.util.List;

import com.crud.accenture.domain.model.Cliente;
import com.crud.accenture.domain.model.LivroCaixa;

public interface ContabilidadeService {
	List<LivroCaixa> findByIdCliente(int idCliente);
	
	Cliente getStatementCliente(int idCliente, Date diaInicial, Date diaFinal);
}
