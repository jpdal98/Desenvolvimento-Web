package com.agenda.br.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.agenda.br.model.Contato;

@Repository
public interface ContatoRepository extends JpaRepository<Contato, Long>{ 
	
	@Query("SELECT c FROM Contato c WHERE c.nome = :nome ")
	List<Contato> findByNome(@Param("nome") String nome);
	
	@Query("SELECT c FROM Contato c WHERE c.sobrenome = :sobrenome ")
	List<Contato> findBySobreNome(@Param("sobrenome") String sobrenome);
	
	@Query("SELECT c FROM Contato c WHERE c.telefone = :telefone ")
	List<Contato> findByTelefone(@Param("telefone") String telefone);
	
	@Query("SELECT c FROM Contato c WHERE c.email = :email ")
	List<Contato> findByEmail(@Param("email") String email);
	
	@Query("SELECT c FROM Contato c WHERE c.empresa = :empresa ")
	List<Contato> findByEmpresa(@Param("empresa") String empresa);
}
