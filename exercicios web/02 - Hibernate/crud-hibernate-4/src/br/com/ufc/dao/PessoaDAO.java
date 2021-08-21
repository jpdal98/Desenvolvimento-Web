package br.com.ufc.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.ufc.model.Pessoa;

public class PessoaDAO {
	
	//criar, atualizar, listar e remover
	
	public void adicionar(Pessoa pessoa) {
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("mapeamento-jpa-hibernate");
		EntityManager manager = fabrica.createEntityManager();
		
		manager.getTransaction().begin();
		manager.persist(pessoa);
		manager.getTransaction().commit();
		
		fabrica.close();
		manager.close();
		
	}
	
	
	public void remove(Long id) {
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("mapeamento-jpa-hibernate");
		EntityManager manager = fabrica.createEntityManager();
		
		Pessoa pessoa = manager.find(Pessoa.class, id);
		
		manager.getTransaction().begin();
		manager.remove(pessoa);
		manager.getTransaction().commit();
		
		fabrica.close();
		manager.close();
		
	}
	
	
	public void alterar (Pessoa pessoa) {
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("mapeamento-jpa-hibernate");
		EntityManager manager = fabrica.createEntityManager();
		
		manager.getTransaction().begin();
		manager.merge(pessoa);
		manager.getTransaction().commit();
		
		fabrica.close();
		manager.close();
	}
	
	
	public List<Pessoa> listar(){
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("mapeamento-jpa-hibernate");
		EntityManager manager = fabrica.createEntityManager();
		
		List<Pessoa> pessoas = manager.createQuery("select p from Pessoa as p").getResultList();
		
		manager.close();
		fabrica.close();
		
		return pessoas;
		
		
	}
	
	public Pessoa buscar(Long id) {
		return null;
	}
	
}
