package com.crud.accenture.domain.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

@Entity @Table(name = "CLIENTES")
public class Cliente {
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataCadastro= new java.sql.Date(System.currentTimeMillis());
	
	@Column(length = 30) @NotNull
	private String nome;
	
	@Column(length = 14) @NotNull
	private String cpfCnpj;
	
	@Column(length = 50) @NotNull
	private String logradouro;	
	
	@Column(length = 40) @NotNull
	private String cidade;
	
	@Column(length = 2) @NotNull
	private String uf;
	
	@Column(length = 8) @NotNull
	private String cep;
	
	@Column(length = 11) 
	private String telefone;
	
	@Column(length = 100) 
	private String email;
}
