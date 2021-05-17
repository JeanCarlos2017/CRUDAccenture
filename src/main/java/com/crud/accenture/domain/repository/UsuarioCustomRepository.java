package com.crud.accenture.domain.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.crud.accenture.domain.model.Usuario;

@Repository
public class UsuarioCustomRepository {
	private final EntityManager entityManager;
	private static final String baseQuery= "select U from Usuario as U ";
	private String queryCustom;
	private String operatorQueryCustom;
	private TypedQuery<Usuario> queryEntityManager;
	

	public UsuarioCustomRepository(EntityManager entityManager) {
		this.entityManager = entityManager;
		this.queryCustom = UsuarioCustomRepository.baseQuery;
		this.operatorQueryCustom= "where ";
	}
	
	public List<Usuario> findUsuario(String nome, String email){
		this.createQueryString(nome, email);
		this.createQuery();
		this.setParamaterQuery(nome, email);
		return this.executeQuery();
	}

	private void createQueryString(String nome, String email) {
		this.tryAppendNameToQuery(nome);
		this.tryAppendEmailToQuery(email);
	}

	private void tryAppendNameToQuery(String nome) {
		if (nome != null) {
			this.queryCustom+= this.operatorQueryCustom + "U.nome = :nome ";
			this.operatorQueryCustom= " and ";
		}
	}

	private void tryAppendEmailToQuery(String email) {
		if (email != null) {
			this.queryCustom+= this.operatorQueryCustom + "U.email = :email ";
			this.operatorQueryCustom= " and ";
		}
	}

	private void createQuery() {
		this.queryEntityManager= this.entityManager.createQuery(this.queryCustom, Usuario.class);
		this.resetQueryCustom();
	}
	
	private void resetQueryCustom() {
		this.queryCustom= UsuarioCustomRepository.baseQuery;	
		this.operatorQueryCustom= "where ";
	}

	private void setParamaterQuery(String nome, String email) {
		this.setparamaterNome(nome);		
		this.setparamaterEmail(email);		
	}

	private void setparamaterNome(String nome) {
		if (nome != null) {
		  this.queryEntityManager.setParameter("nome", nome);
		}
		
	}

	private void setparamaterEmail(String email) {
		if (email != null) {
			  this.queryEntityManager.setParameter("email", email);
			}
	}
	
	private List<Usuario> executeQuery() {
		return this.queryEntityManager.getResultList();
	}
	
}
