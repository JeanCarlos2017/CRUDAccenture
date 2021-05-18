package com.crud.accenture.domain.service;

import java.util.List;

import com.crud.accenture.domain.model.LivroCaixa;

public interface LivroCaixaService {
	
	LivroCaixa addLivroCaixa(LivroCaixa livroCaixa);
	
	LivroCaixa updateLivroCaixa(LivroCaixa livroCaixa);
	
	void deleteLivroCaixa(int idLivroCaixa);
	
	LivroCaixa findById(int idLivroCaixa);
	
	List<LivroCaixa> findByIdCliente(int idCliente);
	
}
