package br.com.ufc.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.ufc.model.Pessoa;

public class PessoaDAO {
	
	//adicionar, listar, remover e atualizar
	public void adicionar(Pessoa pessoa) {
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("crud-hibernate");
		EntityManager manager = fabrica.createEntityManager();
		
		manager.getTransaction().begin();
		manager.persist(pessoa);
		manager.getTransaction().commit();
		
		fabrica.close();
		manager.close();
		
	}
	
	public void remover(Long id) {
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("crud-hibernate");
		EntityManager manager = fabrica.createEntityManager();
		
		Pessoa pessoa = manager.find(Pessoa.class, id);
		
		manager.getTransaction().begin();
		manager.remove(pessoa);
		manager.getTransaction().commit();
		
		manager.close();
		fabrica.close();
	
	}
	
	public Pessoa buscarPorId(Long id) {
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("crud-hibernate");
		EntityManager manager = fabrica.createEntityManager();
		
		Pessoa pessoa = manager.find(Pessoa.class, id);
		
		manager.close();
		fabrica.close();
		
		return pessoa;
		
	}
	
	public void alterar(Pessoa pessoa) {
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("crud-hibernate");
		EntityManager manager = fabrica.createEntityManager();
		
		manager.getTransaction().begin();
		manager.merge(pessoa);
		manager.getTransaction().commit();
		
		manager.close();
		fabrica.close();
		
	}
	
	
	
	public List<Pessoa> retornarLista(){
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("crud-hibernate");
		EntityManager manager = fabrica.createEntityManager();
		
		List<Pessoa> pessoas = 
				manager.createQuery("select p from Pessoa as p")
				.getResultList();
		
		fabrica.close();
		manager.close();
		
		return pessoas;
	}
	
	
	
	
	
	
	
	
	
	
	

}
