package br.com.ufc.teste;

import br.com.ufc.dao.ContatoDAO;
import br.com.ufc.model.Contato;

public class TesteCadastro {
	public static void main(String[] args) {
		ContatoDAO contatoDAO = new ContatoDAO();
		
		Contato contato1 = new Contato();
		contato1.setNome("Matheus Vital");
		contato1.setTelefone("777777");
		
		contatoDAO.adicionar(contato1);
		
		
		Contato contato2 = new Contato();
		contato2.setNome("ronaldo");
		contato2.setTelefone("4333333");
		
		contatoDAO.adicionar(contato2);
		
	}
	
	
}
