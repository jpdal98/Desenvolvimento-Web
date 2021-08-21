package br.com.ufc.dao;

import java.util.List;

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
		
		Veiculo veiculo = manager.find(Veiculo.class, id);
		
		
		manager.getTransaction().begin();
		manager.remove(veiculo);
		manager.getTransaction().commit();
		
		fabrica.close();
		manager.close();
		
		
	}
	
	public Veiculo buscarPorId(Long id) {
		
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("crud-hibernate");
		EntityManager manager = fabrica.createEntityManager();
		
		Veiculo veiculo = manager.find(Veiculo.class, id);
		
		return veiculo;
		
	}
	
	public void alterar(Veiculo veiculo) {
		//Conexao com o banco
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("crud-hibernate");
		EntityManager manager = fabrica.createEntityManager();
		
		//Código de Alteração de um veiculo no banco
		manager.getTransaction().begin();
		manager.merge(veiculo);
		manager.getTransaction().commit();
		
		//Fechando as conexões 
		fabrica.close();
		manager.close();
		
	}
	
	
	public List<Veiculo> listar(){
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("crud-hibernate");
		EntityManager manager = fabrica.createEntityManager();
		
		List<Veiculo> veiculos = manager.createQuery("select v from Veiculo as v").getResultList();
		
		fabrica.close();
		manager.close();
		
		return veiculos;
	}
}
