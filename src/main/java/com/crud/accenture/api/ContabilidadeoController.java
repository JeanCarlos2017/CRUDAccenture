package com.crud.accenture.api;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.crud.accenture.domain.model.LivroCaixa;
import com.crud.accenture.domain.service.ContabilidadeService;

@RestController
@RequestMapping("/contabilidade")
public class ContabilidadeoController {
	private ContabilidadeService contabilidadeService;

	public ContabilidadeoController(ContabilidadeService contabilidadeService) {
		super();
		this.contabilidadeService = contabilidadeService;
	}
	
	@GetMapping("/findAllLivrosClienteById/{idCliente}")
	public ResponseEntity<List<LivroCaixa>> findAllLivrosClienteById(@PathVariable int idCliente){
		return new ResponseEntity<List<LivroCaixa>>(this.contabilidadeService.findByIdCliente(idCliente), HttpStatus.OK);
	}
}
