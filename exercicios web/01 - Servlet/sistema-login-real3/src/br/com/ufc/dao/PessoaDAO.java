package br.com.ufc.dao;
import java.util.ArrayList;
import java.util.List;

import br.com.ufc.model.*;

public class PessoaDAO {
	private List<Pessoa> pessoas;
	
	
	
	
	public PessoaDAO() {
		pessoas = new ArrayList<Pessoa>();
		pessoas.add(new Pessoa("cassio","trinta"));
		pessoas.add(new Pessoa("ralf","pitbull"));
	}




	public Pessoa buscarPessoa(String username, String senha) {
		Pessoa pessoa = new Pessoa(username,senha);
		
		if(pessoas.contains(pessoa)) {
			return pessoa;
		}
		
		return null;
		
		
	}
	
	
}

