package com.crud.accenture.domain.model;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity @Table(name = "LIVRO_CAIXA")
public class LivroCaixa {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@NotNull
	private Date dataCadastro;
	
	@Column(length = 50) @NotNull
	private String descricao;
	
	@NotNull
	private char tipo;
	
	@NotNull 
	private BigDecimal valor;
	
	
	@ManyToOne @JoinColumn(name= "id_cliente")
	@OnDelete(action = OnDeleteAction.CASCADE)
	private Cliente cliente;
	
	public LivroCaixa() {}
	
	//getters and setter 

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(Date dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public char getTipo() {
		return tipo;
	}

	public void setTipo(char tipo) {
		this.tipo = tipo;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	
}
