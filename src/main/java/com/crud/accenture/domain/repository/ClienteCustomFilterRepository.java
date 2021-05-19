package com.crud.accenture.domain.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.crud.accenture.domain.model.Cliente;

@Repository
public class ClienteCustomFilterRepository {
	private final EntityManager entityManager;
	private static final String baseQuery= "select C from Cliente as C ";
	private String queryCustom;
	private String operatorQueryCustom;
	private TypedQuery<Cliente> queryEntityManager;
	
	public ClienteCustomFilterRepository(EntityManager entityManager) {
		this.entityManager = entityManager;
		this.queryCustom = ClienteCustomFilterRepository.baseQuery;
		this.operatorQueryCustom= "where ";
	}
	
	public List<Cliente> filtrarCliente(String nome, String cpfCnpj, String cidade, String uf){
		this.createQueryString(nome, cpfCnpj, cidade, uf);
		this.createQuery();
		this.setParamaterQuery(nome, cpfCnpj, cidade, uf);
		return this.executeQuery();
	}

	private void createQueryString(String nome, String cpfCnpj, String cidade, String uf) {
		this.tryAppendNomeToQuery(nome);
		this.tryAppendCpfCnpjToQuery(cpfCnpj);
		this.tryAppendCidadeToQuery(cidade);
		this.tryAppendUfToQuery(uf);
	}

	private void tryAppendNomeToQuery(String nome) {
		if (nome != null) {
			this.queryCustom+= this.operatorQueryCustom + "C.nome = :nome ";
			this.operatorQueryCustom= " and ";
		}
		
	}

	private void tryAppendCpfCnpjToQuery(String cpfCnpj) {
		if (cpfCnpj != null) {
			this.queryCustom+= this.operatorQueryCustom + "C.cpfCnpj = :cpfCnpj ";
			this.operatorQueryCustom= " and ";
		}
	}

	private void tryAppendCidadeToQuery(String cidade) {
		if (cidade != null) {
			this.queryCustom+= this.operatorQueryCustom + "C.cidade = :cidade ";
			this.operatorQueryCustom= " and ";
		}
		
	}

	private void tryAppendUfToQuery(String uf) {
		if (uf != null) {
			this.queryCustom+= this.operatorQueryCustom + "C.uf = :uf ";
			this.operatorQueryCustom= " and ";
		}
		
	}
	
	private void createQuery() {
		this.queryEntityManager= this.entityManager.createQuery(this.queryCustom, Cliente.class);
		this.resetQueryCustom();
		
	}

	private void resetQueryCustom() {
		this.queryCustom= ClienteCustomFilterRepository.baseQuery;	
		this.operatorQueryCustom= "where ";
	}
	
	private void setParamaterQuery(String nome, String cpfCnpj, String cidade, String uf) {
		this.setparamaterNome(nome);
		this.setparamaterCpfCnpj(cpfCnpj);
		this.setparamaterCidade(cidade);
		this.setparamaterUF(uf);
	}

	private void setparamaterNome(String nome) {
		if (nome != null) {
			  this.queryEntityManager.setParameter("nome", nome);
		}
	}

	private void setparamaterCpfCnpj(String cpfCnpj) {
		if (cpfCnpj != null) {
			  this.queryEntityManager.setParameter("cpfCnpj", cpfCnpj);
		}
	}

	private void setparamaterCidade(String cidade) {
		if (cidade != null) {
			  this.queryEntityManager.setParameter("cidade", cidade);
		}
	}

	private void setparamaterUF(String uf) {
		if (uf != null) {
			  this.queryEntityManager.setParameter("uf", uf);
		}
	}
	
	private List<Cliente> executeQuery() {
		return this.queryEntityManager.getResultList();
	}
}
