package br.com.ufc.teste;

import br.com.ufc.dao.PessoaDAO;
import br.com.ufc.model.Pessoa;

public class PessoaTeste {
	public static void main(String[] args) {
		Pessoa pessoa = new Pessoa();
		pessoa.setNome("Julio");
		pessoa.setTime("Ceará");
		
		PessoaDAO pessoaDAO = new PessoaDAO();
		pessoaDAO.cadastrar(pessoa);
		
	}
}
