package br.com.ufc.teste;

import br.com.ufc.dao.PessoaDAO;
import br.com.ufc.dao.VeiculoDAO;
import br.com.ufc.model.Pessoa;
import br.com.ufc.model.Veiculo;

public class Teste {
	public static void main(String[] args) {
		VeiculoDAO veiculoDAO = new VeiculoDAO();
		
//		Pessoa pessoa2 = new Pessoa();
//		pessoa2.setNome("Elenilson");
//		pessoa2.setTelefone("8787878787");
		PessoaDAO pessoaDAO = new PessoaDAO();
		//pessoaDAO.adicionar(pessoa2);
		Pessoa pessoa = pessoaDAO.buscarPorId(1L);
		pessoaDAO.remover(pessoa.getId());
//		Veiculo veiculo = new Veiculo();
//		veiculo.setMarca("MIT");
//		veiculo.setModelo("Eclipse");
//		veiculo.setPlaca("web-2019");
//		//veiculo.setProprietario(pessoa);
//		veiculoDAO.adicionar(veiculo);
		
	}
}
