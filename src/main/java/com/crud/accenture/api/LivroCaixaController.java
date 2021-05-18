package com.crud.accenture.api;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.crud.accenture.domain.model.LivroCaixa;
import com.crud.accenture.domain.service.LivroCaixaService;

@RestController
@RequestMapping("/livro_caixa")
public class LivroCaixaController {
	private LivroCaixaService livroCaixaService;

	public LivroCaixaController(LivroCaixaService livroCaixaService) {
		super();
		this.livroCaixaService = livroCaixaService;
	}
	
	@GetMapping("/findById/{id_livro_caixa}")
	public ResponseEntity<LivroCaixa> findById(@PathVariable int id_livro_caixa){
		return new ResponseEntity<LivroCaixa>(this.livroCaixaService.findById(id_livro_caixa), HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<LivroCaixa> addLivroCaixa(@Valid @RequestBody LivroCaixa livroCaixa){
		return new ResponseEntity<LivroCaixa>(this.livroCaixaService.addLivroCaixa(livroCaixa), HttpStatus.CREATED);
	}
	
	@PutMapping
	public ResponseEntity<LivroCaixa> updateLivroCaixa(@Valid @RequestBody LivroCaixa livroCaixa){
		return new ResponseEntity<LivroCaixa>(this.livroCaixaService.updateLivroCaixa(livroCaixa), HttpStatus.ACCEPTED);
	}
	
	@DeleteMapping("/deleteById/{id_livro_caixa}")
	public ResponseEntity<Void> deleteById(@PathVariable int id_livro_caixa){
		this.livroCaixaService.deleteLivroCaixa(id_livro_caixa);
		return ResponseEntity.noContent().build();
	}
	
}
