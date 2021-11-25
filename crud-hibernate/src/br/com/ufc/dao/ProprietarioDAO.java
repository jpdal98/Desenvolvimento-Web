package br.com.ufc.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.ufc.model.Proprietario;
import br.com.ufc.model.Veiculo;

public class ProprietarioDAO {
	public void adicionar(Proprietario proprietario) {
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("crud-hibernate");
		EntityManager manager = fabrica.createEntityManager();
		
		manager.getTransaction().begin();
		manager.persist(proprietario);
		manager.getTransaction().commit();
		
		fabrica.close();
		manager.close();
		
	}
	
	public void remover(Long id) {
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("crud-hibernate");
		EntityManager manager = fabrica.createEntityManager();
		
		Proprietario proprietario = manager.find(Proprietario.class, id);
		
		
		manager.getTransaction().begin();
		manager.remove(proprietario);
		manager.getTransaction().commit();
		
		fabrica.close();
		manager.close();
		
		
	}
	
	public Proprietario buscarPorId(Long id) {

		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("crud-hibernate");
		EntityManager manager = fabrica.createEntityManager();
		
		Proprietario proprietario = manager.find(Proprietario.class, id);
		
		return proprietario;
		
	}
	
	public void alterar(Proprietario proprietario) {
		//Conexao com o banco
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("crud-hibernate");
		EntityManager manager = fabrica.createEntityManager();
		
		//Código de Alteração de um proprietario no banco
		manager.getTransaction().begin();
		manager.merge(proprietario);
		manager.getTransaction().commit();
		
		//Fechando as conexões 
		fabrica.close();
		manager.close();
		
	}
	
	
	public List<Proprietario> listar(){
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("crud-hibernate");
		EntityManager manager = fabrica.createEntityManager();
		
		List<Proprietario> proprietarios = manager.createQuery("select v from Proprietario as v").getResultList();
		
		fabrica.close();
		manager.close();
		
		return proprietarios;
	}
}
