package br.com.ufc.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.ufc.model.Pessoa;

public class PessoaDAO {
	
	//cadastrar, remover, atualizar e listar 
	
	public void cadastrar(Pessoa pessoa) {
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("mapeamento-jpa-hibernate");
		EntityManager manager = fabrica.createEntityManager();
		
		manager.getTransaction().begin();
		manager.persist(pessoa);
		manager.getTransaction().commit();
		
		fabrica.close();
		manager.close();
		
	}
	
}
