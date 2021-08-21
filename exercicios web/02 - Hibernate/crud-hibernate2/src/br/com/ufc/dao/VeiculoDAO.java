package br.com.ufc.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.ufc.model.Veiculo;

public class VeiculoDAO {
	
	
	public void adicionar(Veiculo veiculo) {
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("crud-hibernate");
		EntityManager manager = fabrica.createEntityManager();
		
		manager.getTransaction().begin();
		manager.persist(veiculo);
		manager.getTransaction().commit();
		
		fabrica.close();
		manager.close();
		
		
	}
	
	public void remover(Long id) {
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("crud-hibernate");
		EntityManager manager = fabrica.createEntityManager();
		
		manager.getTransaction().begin();
		Veiculo veiculo = manager.find(Veiculo.class, id);
		manager.remove(veiculo);
		manager.getTransaction().commit();
		
		fabrica.close();
		manager.close();
	}
	
	
	
	
	
	
	
	
	
	
	

}
