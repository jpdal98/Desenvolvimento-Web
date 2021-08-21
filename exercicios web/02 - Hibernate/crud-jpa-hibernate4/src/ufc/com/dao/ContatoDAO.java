package ufc.com.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import ufc.com.model.Contato;

public class ContatoDAO {
	
	//adicionar, deletar, atualizar e listar CRUD
	
	public void adicionar(Contato contato) {
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("crud-jpa-hibernate4");
		EntityManager manager = fabrica.createEntityManager();
		
		manager.getTransaction().begin();
		manager.persist(contato);
		manager.getTransaction().commit();
		
		fabrica.close();
		manager.close();
	
	}
	
	public void alterar(Contato contato) {
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("crud-jpa-hibernate4");
		EntityManager manager = fabrica.createEntityManager();
		
		manager.getTransaction().begin();
		manager.merge(contato);
		manager.getTransaction().commit();
		
		fabrica.close();
		manager.close();
	
	}
	
	public void remover(Long id) {
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("crud-jpa-hibernate4");
		EntityManager manager = fabrica.createEntityManager();
		
		manager.getTransaction().begin();
		Contato contato = manager.find(Contato.class, id);
		manager.remove(contato);
		manager.getTransaction().commit();
		
		fabrica.close();
		manager.close();
	
	}
	
	public Contato buscarPorId(Long id) {
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("crud-jpa-hibernate4");
		EntityManager manager = fabrica.createEntityManager();
		
		Contato contato = manager.find(Contato.class, id);
		
		fabrica.close();
		manager.close();
		
		return contato;
	}
	
	

}
