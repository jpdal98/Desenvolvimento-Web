package com.agenda.br.service.impl;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.agenda.br.exception.ContatoException;
import com.agenda.br.model.Contato;
import com.agenda.br.repository.ContatoRepository;
import com.agenda.br.service.ContatoService;
import com.agenda.br.util.Messages;

@Service
public class ContatoServiceImpl implements ContatoService {

	@Autowired
	private ContatoRepository contatoRepo;

	@Override
	public Contato cadastrarContato(Contato contato) {
		return contatoRepo.save(contato);
	}

	@Override
	public void excluiContato(Long Id) throws ContatoException {
		
		if(!contatoRepo.findById(Id).isPresent()) {
			throw new ContatoException(Messages.ERRO_CONTATO_NAO_ENCONTRADO);
		}
		
		contatoRepo.deleteById(Id);
	}

	@Override
	public Contato atualizarContato(Contato novoContato, Long id) throws ContatoException {
		Contato contato = contatoRepo.findById(id).get();
		if (contato == null) {
			throw new ContatoException(Messages.ERRO_CONTATO_NAO_ENCONTRADO);
		}
		
		BeanUtils.copyProperties(novoContato, contato, "id");
		return contatoRepo.save(contato);
	}

	@Override
	public List<Contato> listarContatos() {
		return contatoRepo.findAll(); 
	}

	@Override
	public List<Contato> buscarContatoNome(String nome) throws ContatoException{
		
		if (contatoRepo.findByNome(nome).isEmpty()) {
			throw new ContatoException(Messages.ERRO_CONTATO_NAO_ENCONTRADO);
		}
		
		List<Contato> contato = contatoRepo.findByNome(nome);
		return contato;
	}
	
	@Override
	public List<Contato> buscarContatoSobreNome(String sobrenome) throws ContatoException{
		
		if (contatoRepo.findBySobreNome(sobrenome).isEmpty()) {
			throw new ContatoException(Messages.ERRO_CONTATO_NAO_ENCONTRADO);
		}
		
		List<Contato> contato = contatoRepo.findBySobreNome(sobrenome);
		return contato;
	}
	
	@Override
	public List<Contato> buscarContatoTelefone(String telefone) throws ContatoException{
		
		if (contatoRepo.findByTelefone(telefone).isEmpty()) {
			throw new ContatoException(Messages.ERRO_CONTATO_NAO_ENCONTRADO);
		}
		
		List<Contato> contato = contatoRepo.findByTelefone(telefone);
		return contato;
	}
	
	@Override
	public List<Contato> buscarContatoEmail(String email) throws ContatoException{
		
		if (contatoRepo.findByEmail(email).isEmpty()) {
			throw new ContatoException(Messages.ERRO_CONTATO_NAO_ENCONTRADO);
		}
		
		List<Contato> contato = contatoRepo.findByEmail(email);
		return contato;
	}
	
	@Override
	public List<Contato> buscarContatoEmpresa(String empresa) throws ContatoException{
		
		if (contatoRepo.findByEmpresa(empresa).isEmpty()) {
			throw new ContatoException(Messages.ERRO_CONTATO_NAO_ENCONTRADO);
		}
		
		List<Contato> contato = contatoRepo.findByEmpresa(empresa);
		return contato;
	}
}
