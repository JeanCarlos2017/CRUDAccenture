package com.crud.accenture.domain.service;

import com.crud.accenture.domain.model.LivroCaixa;

public interface LivroCaixaService {
	
	LivroCaixa adicionarLivroCaixa(LivroCaixa livroCaixa);
	
	LivroCaixa alterarLivroCaixa(LivroCaixa livroCaixa);
	
	void deletarLivroCaixa(int idLivroCaixa);
	
	LivroCaixa buscarLivroPorId(int idLivroCaixa);
	
	
	
}
