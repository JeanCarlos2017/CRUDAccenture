package com.crud.accenture.domain.service;

import com.crud.accenture.domain.model.LivroCaixa;

public interface LivroCaixaService {
	
	LivroCaixa addLivroCaixa(LivroCaixa livroCaixa);
	
	LivroCaixa updateLivroCaixa(LivroCaixa livroCaixa);
	
	void deleteLivroCaixa(int idLivroCaixa);
	
	LivroCaixa findById(int idLivroCaixa);
	
	
	
}
