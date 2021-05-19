package com.crud.accenture.domain.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.crud.accenture.domain.model.Cliente;
import com.crud.accenture.domain.model.LivroCaixa;

public interface LivroCaixaRepository extends JpaRepository<LivroCaixa, Integer>{
	boolean existsById(int id);
	
	List<LivroCaixa> findByCliente(Cliente cliente);
	
	@Query("select l from LivroCaixa l  where "+
			  "l.cliente = ?1 and "+
			  "l.dataCadastro between ?2 and ?3 "+
			  "order by l.dataCadastro asc")
	List<LivroCaixa> findAllLivroCaixaByClienteBetween(Cliente cliente, Date dataInicial, Date dataFinal);
}
