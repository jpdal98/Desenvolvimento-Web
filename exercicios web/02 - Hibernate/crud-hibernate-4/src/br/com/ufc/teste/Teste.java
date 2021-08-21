package br.com.ufc.teste;

import br.com.ufc.dao.PessoaDAO;
import br.com.ufc.model.Pessoa;

public class Teste {
	public static void main(String[] args) {
		PessoaDAO pessoaDAO = new PessoaDAO();
		
		Pessoa pessoa = new Pessoa();
		pessoa.setNome("Júlio");
		pessoa.setTime("Corinthians");
		
		pessoaDAO.adicionar(pessoa);
		
		//pessoaDAO.remove(5L);
		
		
		
		
	}
}
