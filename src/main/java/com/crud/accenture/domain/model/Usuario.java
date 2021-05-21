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

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity @Table(name = "USUARIO")
public class Usuario {
	private static char ATIVO = 'A';
	
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@NotNull
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataCadastro= new java.sql.Date(System.currentTimeMillis());
	
	@Column(length = 30) @NotNull
	private String nome;
	
	@Column(length = 15, unique = true) @NotNull
	private String login;
	
	@Column(length = 10) @NotNull
	private String senha;
	
	@Column(length = 11)
	private String telefone;
	
	@Column(length = 100) 
	private String email;
	
	@Column(length = 1) @NotNull
	private char perfil;
	
	@Column(length = 1) @NotNull
	private char status;
	
	public Usuario() {}
	
	@JsonIgnore
	public boolean isAtivo() {
		return Character.toUpperCase(this.status) == Usuario.ATIVO;
	}
	
	//getters ans setters 
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public char getPerfil() {
		return perfil;
	}

	public void setPerfil(char perfil) {
		this.perfil = perfil;
	}

	public char getStatus() {
		return status;
	}

	public void setStatus(char status) {
		this.status = status;
	}

	public Date getDataCadastro() {
		return dataCadastro;
	}


	public void setDataCadastro(Date dataCadastro) {
		this.dataCadastro = dataCadastro;
	}
	
	
}
