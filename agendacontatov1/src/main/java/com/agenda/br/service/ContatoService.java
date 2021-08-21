package com.agenda.br.service;

import java.util.List;


import com.agenda.br.exception.ContatoException;
import com.agenda.br.model.Contato;

public interface ContatoService {

	Contato cadastrarContato(Contato contato);
	
	void excluiContato(Long Id) throws ContatoException;
	
	Contato atualizarContato(Contato novoContato, Long id) throws ContatoException;
	
	List<Contato> listarContatos();
	
	List<Contato> buscarContatoNome(String nome) throws ContatoException;
	
	List<Contato> buscarContatoSobreNome(String sobrenome) throws ContatoException;
	
	List<Contato> buscarContatoTelefone(String telefone) throws ContatoException;
	
	List<Contato> buscarContatoEmail(String email) throws ContatoException;
	
	List<Contato> buscarContatoEmpresa(String empresa) throws ContatoException;
}
