package com.crud.accenture.api;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.crud.accenture.domain.model.LivroCaixa;
import com.crud.accenture.domain.service.ContabilidadeService;
import com.crud.accenture.dto.ClienteDTO;

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
		return new ResponseEntity<List<LivroCaixa>>(this.contabilidadeService.buscaTodosLivrosCaixaPeloIdCliente(idCliente), HttpStatus.OK);
	}
	
	@GetMapping
	public ResponseEntity<ClienteDTO> getContabiliade(
			@RequestParam(value = "id_cliente", required = false) int id,
			@RequestParam(value = "data_inicial", required = false) String dataInicial,
			@RequestParam(value = "data_final", required = false) String dataFinal
		) {
		return new ResponseEntity<ClienteDTO>(this.contabilidadeService.pegarExtratoDoCliente(id, dataInicial, dataFinal), 
				HttpStatus.OK);
	}
}
