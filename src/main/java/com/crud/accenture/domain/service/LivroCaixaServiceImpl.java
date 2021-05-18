package com.crud.accenture.domain.service;

import org.springframework.stereotype.Service;

import com.crud.accenture.api.exception.ResourceNotFoundException;
import com.crud.accenture.domain.model.LivroCaixa;
import com.crud.accenture.domain.repository.LivroCaixaRepository;

@Service
public class LivroCaixaServiceImpl implements LivroCaixaService {
	private LivroCaixaRepository livroCaixaRepository;
	
	public LivroCaixaServiceImpl(LivroCaixaRepository livroCaixaRepository, ClienteService clienteService) {
		super();
		this.livroCaixaRepository = livroCaixaRepository;
	}

	@Override
	public LivroCaixa addLivroCaixa(LivroCaixa livroCaixa) {
		return this.livroCaixaRepository.save(livroCaixa);
	}

	@Override
	public LivroCaixa updateLivroCaixa(LivroCaixa livroCaixa) {
		if(this.livroCaixaRepository.existsById(livroCaixa.getId())) {
			return this.livroCaixaRepository.save(livroCaixa);
		}else {
			return this.throwIdNotFound();
		}
	}
	
	private LivroCaixa throwIdNotFound() {
		throw new ResourceNotFoundException("Id do livro caixa não  encontrado, por favor tente novamente");
	}
	@Override
	public void deleteLivroCaixa(int idLivroCaixa) {
		if(this.livroCaixaRepository.existsById(idLivroCaixa)) {
			 this.livroCaixaRepository.deleteById(idLivroCaixa);
		}else {
			this.throwIdNotFound();
		}
	}

	@Override
	public LivroCaixa findById(int idLivroCaixa) {
		if(this.livroCaixaRepository.existsById(idLivroCaixa)) {
			return this.livroCaixaRepository.findById(idLivroCaixa).get();
		}else {
			return this.throwIdNotFound();
		}
	}

	
}
