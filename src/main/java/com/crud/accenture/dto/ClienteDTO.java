package com.crud.accenture.dto;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.crud.accenture.domain.model.Cliente;
import com.crud.accenture.domain.model.LivroCaixa;

public class ClienteDTO {
	private int id;
	private String nome;
	private String cpf_cnpj;
	private String telefone;
	private List<LivroCaixaDTO> contabil= new ArrayList<>();
	
	
	public ClienteDTO(Cliente cliente, List<LivroCaixa> todosLivroCaixaDoCliente) {
		super();
		this.id = cliente.getId();
		this.nome = cliente.getNome();
		this.cpf_cnpj = cliente.getCpfCnpj();
		this.telefone = cliente.getTelefone();
		this.setContabil(todosLivroCaixaDoCliente);
		this.setSaldoCliente();
	}
	
	private void setContabil(List<LivroCaixa> todosLivroCaixaDoCliente) {
		for(LivroCaixa livro: todosLivroCaixaDoCliente) {
			this.contabil.add(new LivroCaixaDTO(livro));
		}
	}
	
	private void setSaldoCliente() {
		this.ordenaLivroCaixaPorData();
		this.setSaldoDeTodosLivrosCaixa();
		this.filtraOsLivrosPorintervaloDeData();
	}

	

	private void ordenaLivroCaixaPorData() {
		this.contabil.sort( (livro1, livro2) -> livro1.getDataLancamento().compareTo(livro2.getDataLancamento()));
	}

	private void setSaldoDeTodosLivrosCaixa() {
		BigDecimal saldo = new BigDecimal("0.00");
		for(LivroCaixaDTO livro: this.contabil) {
			saldo = setSaldoDeCadaLivroCaixa(saldo, livro);
		}
		
	}

	private BigDecimal setSaldoDeCadaLivroCaixa(BigDecimal saldo, LivroCaixaDTO livro) {
		saldo= this.calculaSaldoLivroAtual(saldo, livro);
		livro.setSaldo(saldo);
		return saldo;
	}
	
	private BigDecimal calculaSaldoLivroAtual(BigDecimal saldo, LivroCaixaDTO livro) {
		if(livro.isCredito()) {
			saldo = saldo.add(livro.getValor());
		}
		
		if(livro.isDebito()) {
			saldo = saldo.subtract(livro.getValor());
		}
		return saldo;
	}

	public void filtraOsLivrosPorintervaloDeData() {
		// TODO Auto-generated method stub
		//ver como implementa esse método, por que ele precisa das datas
		
	}

	//getters and setters
	public int getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public String getCpf_cnpj() {
		return cpf_cnpj;
	}

	public String getTelefone() {
		return telefone;
	}

	public List<LivroCaixaDTO> getContabil() {
		return contabil;
	}

}
