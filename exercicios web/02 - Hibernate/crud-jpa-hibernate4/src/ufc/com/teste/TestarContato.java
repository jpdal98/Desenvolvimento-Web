package ufc.com.teste;

import java.util.List;

import ufc.com.dao.ContatoDAO;
import ufc.com.model.Contato;

public class TestarContato {

	public static void main(String[] args) {
		Contato contato1 = new Contato();
		//contato1.setId(1L);
		contato1.setNome("Cassio");
		contato1.setTelefone("paredao@gmail.com");
		//contato.setEndereco("Rua caninde");
		//contato.setId(1L);
		
		
		ContatoDAO dao = new ContatoDAO();
		dao.adicionar(contato1);;
		
		/*Contato contato2 = new Contato();
		//contato.setId(1L);
		contato2.setNome("Rodriguinho");
		contato2.setTelefone("mito@gmail.com");
		dao.adicionar(contato2);*/
		
		
		
		//contato = dao.recuperar(1L);
		//System.out.println(contato.getNome());
		
	}

}
