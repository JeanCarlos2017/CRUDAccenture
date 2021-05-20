package com.crud.accenture.domain.repository.filtro;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.StringUtils;

import com.crud.accenture.domain.model.Cliente;

public class FiltroCliente {
	private String nome;
	private String cpfCnpj;
	private String cidade;
	private String uf;
	private HashMap<String, String> hashCamposFiltro = new HashMap<>();
	
	public FiltroCliente(String nome, String cpfCnpj, String cidade, String uf) {
		super();
		this.nome = nome;
		this.cpfCnpj = cpfCnpj;
		this.cidade = cidade;
		this.uf = uf;
		this.iniciaTabelaHashCamposFiltro();
	}
	
	
	private void iniciaTabelaHashCamposFiltro() {
		this.hashCamposFiltro.put("nome", this.nome);
		this.hashCamposFiltro.put("cpfCnpj", this.cpfCnpj);
		this.hashCamposFiltro.put("cidade", this.cidade);
		this.hashCamposFiltro.put("uf", this.uf);
		
	}


	public Specification<Cliente> toSpec(){
		return (root, query, builder) ->{
			List<Predicate> listaDePredicados = new ArrayList<>();
			this.percorreCamposFiltro(root, listaDePredicados, builder);
			
			Predicate[] predicateBuild = this.predicateSpecification(listaDePredicados.size());
			return builder.and(listaDePredicados.toArray(predicateBuild));
		};
	}

	private void percorreCamposFiltro(Root<Cliente> root, List<Predicate> listaDePredicados, CriteriaBuilder builder) {
		for(String nomeCampo : this.hashCamposFiltro.keySet()) {
			this.addFiltro(nomeCampo, root, listaDePredicados, builder);
		}
	}

	private void addFiltro(String nomeCampo, Root<Cliente> root, 
				List<Predicate> listaDePredicados, CriteriaBuilder builder) {
		
		if(this.verificaCampoFiltro(nomeCampo)) {
			Path<String> campoFiltro = root.<String>get(nomeCampo);
			Predicate predicadoCampoFiltro = builder.equal(campoFiltro, this.hashCamposFiltro.get(nomeCampo));
			listaDePredicados.add(predicadoCampoFiltro);
		}
		
	}

	private boolean verificaCampoFiltro(String nomeCampo) {
		return StringUtils.hasText(this.hashCamposFiltro.get(nomeCampo));
	}
	
	private Predicate[] predicateSpecification(int tamanhoListaPredicado) {
		return new Predicate[tamanhoListaPredicado];
	}

}
