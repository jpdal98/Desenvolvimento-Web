package br.com.ufc.teste;

import br.com.ufc.dao.ProprietarioDAO;
import br.com.ufc.dao.VeiculoDAO;
import br.com.ufc.model.Proprietario;
import br.com.ufc.model.Veiculo;

public class TesteVeiculoProprietario {
	public static void main(String[] args) {
		ProprietarioDAO proprietarioDAO = new ProprietarioDAO();
		VeiculoDAO veiculoDAO = new VeiculoDAO();
		
		Veiculo hb20 = veiculoDAO.buscarPorId(6L);
		Veiculo hilux = veiculoDAO.buscarPorId(14L);
		
		Proprietario proprietario = proprietarioDAO.buscarPorId(15L);
//		proprietario.setEmail("wesley@gmail.com");
//		proprietario.setNome("Wesley");
//		proprietario.setTelefone("4334343");
//		proprietario.getVeiculo().add(hb20);
//		proprietario.getVeiculo().add(hilux);
//		
//		proprietarioDAO.adicionar(proprietario);
		
		hb20.setProprietario(proprietario);
		hilux.setProprietario(proprietario);
		
		//veiculoDAO.alterar(hb20);
		veiculoDAO.alterar(hilux);
	
		
		

		
		
		
		
		
		
	}
}
