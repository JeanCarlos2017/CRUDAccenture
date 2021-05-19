package com.crud.accenture.dto;

import java.math.BigDecimal;
import java.util.Date;

import com.crud.accenture.domain.model.LivroCaixa;

public class LivroCaixaDTO {
	private static final char CREDITO = 'C';
	private static final char DEBITO = 'D';
	
	private Date dataLancamento;
	private String descricao;
	private char tipo;
	private BigDecimal valor; 
	private BigDecimal saldo;
	
	public LivroCaixaDTO(LivroCaixa livroCaixa) {
		super();
		this.dataLancamento = livroCaixa.getDataCadastro();
		this.descricao = livroCaixa.getDescricao();
		this.tipo = Character.toUpperCase(livroCaixa.getTipo());
		this.valor = livroCaixa.getValor();
	}
	
	
	@Override
	public String toString() {
		return "LivroCaixaDTO [dataLancamento=" + dataLancamento + ", descricao=" + descricao + ", tipo=" + tipo
				+ ", valor=" + valor + ", saldo=" + saldo + "]";
	}
	
	public boolean isCredito() {
		return this.tipo == LivroCaixaDTO.CREDITO;
	}
	
	public boolean isDebito() {
		return this.tipo == LivroCaixaDTO.DEBITO;
	}

	//getters and setters 
	public void setSaldo(BigDecimal saldo) {
		this.saldo = saldo;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public Date getDataLancamento() {
		return dataLancamento;
	}


	public BigDecimal getSaldo() {
		return saldo;
	}


	public char getTipo() {
		return tipo;
	}


	public String getDescricao() {
		return descricao;
	}
	
	
	
}
