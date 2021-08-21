package br.com.ufc.dao;

import java.util.ArrayList;
import java.util.List;

import br.com.ufc.model.Pessoa;

public class PessoaDAO {
	
	private List<Pessoa> pessoas;
	private static PessoaDAO pessoaDAO;
	
	private PessoaDAO() {
		pessoas = new ArrayList<Pessoa>();
	}
	
	public static PessoaDAO getInstance() {
		if(pessoaDAO == null) {
		pessoaDAO = new PessoaDAO();
		}
		
		return pessoaDAO;
	}
	
//	public PessoaDAO() {
//		
//	}
	
	public void cadastrarPessoa(Pessoa pessoa) {
		pessoas.add(pessoa);
	}

	@Override
	public String toString() {
		return "PessoaDAO [pessoas=" + pessoas + "]";
	}
	
	

}
