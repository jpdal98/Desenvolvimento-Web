package br.com.ufc.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.ufc.model.Contato;

public class ContatoDAO {
	//adicionar - remover - listar - atualizar
	
	public void adicionar(Contato contato) {
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("crud-hibernate");
		EntityManager manager = fabrica.createEntityManager();
		
		manager.getTransaction().begin();
		manager.persist(contato);
		manager.getTransaction().commit();
		
		fabrica.close();
		manager.close();
		
	}
	
	public void remover(Long id) {
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("crud-hibernate");
		EntityManager manager = fabrica.createEntityManager();
		
		Contato contato = manager.find(Contato.class, id);
		
		
		manager.getTransaction().begin();
		manager.remove(contato);
		manager.getTransaction().commit();
		
		fabrica.close();
		manager.close();
		
		
	}
	
	public Contato buscarPorId(Long id) {
		return null;
	}
	
	public void alterar(Contato contato) {
		//Conexao com o banco
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("crud-hibernate");
		EntityManager manager = fabrica.createEntityManager();
		
		//Código de Alteração de um contato no banco
		manager.getTransaction().begin();
		manager.merge(contato);
		manager.getTransaction().commit();
		
		//Fechando as conexões 
		fabrica.close();
		manager.close();
		
	}
	
	
	public List<Contato> listar(){
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("crud-hibernate");
		EntityManager manager = fabrica.createEntityManager();
		
		List<Contato> contatos = manager.createQuery("select c from Contato as c").getResultList();
		
		fabrica.close();
		manager.close();
		
		return contatos;
	}
	
	
	
	
	
	
	
}
