package com.crud.accenture.dto;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.crud.accenture.domain.model.LivroCaixa;
import com.fasterxml.jackson.annotation.JsonIgnore;

public class LivroCaixaDTO {
	private static final char CREDITO = 'C';
	private static final char DEBITO = 'D';
	private static final String FORMATO_DATA_SAIDA = "dd/MM/yyyy";
	
	private Date dataLancamentoTipoDate;
	private String dataLancamento;
	private String descricao;
	private char tipo;
	private BigDecimal valor; 
	private BigDecimal saldo;
	
	public LivroCaixaDTO(LivroCaixa livroCaixa) {
		super();
		this.dataLancamentoTipoDate = livroCaixa.getDataCadastro();
		this.formatarDataLancamentoParaFormatoDeSaida();
		this.descricao = livroCaixa.getDescricao();
		this.tipo = Character.toUpperCase(livroCaixa.getTipo());
		this.valor = livroCaixa.getValor();
	}
	
	
	private void formatarDataLancamentoParaFormatoDeSaida() {
		SimpleDateFormat formatador = new SimpleDateFormat(LivroCaixaDTO.FORMATO_DATA_SAIDA);	
		this.dataLancamento = formatador.format(dataLancamentoTipoDate);
	}


	@Override
	public String toString() {
		return "LivroCaixaDTO [dataLancamento=" + dataLancamento + ", descricao=" + descricao + ", tipo=" + tipo
				+ ", valor=" + valor + ", saldo=" + saldo + "]";
	}
	
	@JsonIgnore
	public boolean isCredito() {
		return this.tipo == LivroCaixaDTO.CREDITO;
	}
	
	@JsonIgnore
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

	public String getDataLancamento() {
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
