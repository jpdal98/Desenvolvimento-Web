package comufc.dao;

import java.util.ArrayList;
import java.util.List;

import com.ufc.model.Pessoa;

public class PessoaDAO {
	
	private List<Pessoa> pessoas;
	
	public PessoaDAO() {
		pessoas = new ArrayList<Pessoa>();
		pessoas.add(new Pessoa("julio","123"));
		pessoas.add(new Pessoa("carlos", "ceara"));
		
	}

	public Pessoa autenticar(String username, String senha) {
		Pessoa pessoa = new Pessoa(username,senha);
		
		if(pessoas.contains(pessoa)) {
			return pessoa;
		}
		
		return null;
	}
}
