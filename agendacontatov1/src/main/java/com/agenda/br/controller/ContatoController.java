package com.agenda.br.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.agenda.br.exception.ContatoException;
import com.agenda.br.model.Contato;
import com.agenda.br.service.ContatoService;

@RestController
@RequestMapping("/contato")
public class ContatoController {

	@Autowired
	private ContatoService contatoService;
	
	@PostMapping("/cadastrar")
	public ResponseEntity<Contato> cadastrar(@RequestBody @Valid Contato contato) {
		return ResponseEntity.ok(contatoService.cadastrarContato(contato));
	}
	
	@DeleteMapping("/excluir/{id}")
	public ResponseEntity<?> excluir(@PathVariable("id") Long id) throws ContatoException {
		contatoService.excluiContato(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
	@GetMapping("/listar")
	public ResponseEntity<List<Contato>> listar() {
		return ResponseEntity.ok(contatoService.listarContatos());
	}
	
	@PutMapping("/editar/{contatoId}")
	public ResponseEntity<Contato> editar(@RequestBody Contato contato, @PathVariable("contatoId") Long id) throws ContatoException {
		return ResponseEntity.ok(contatoService.atualizarContato(contato, id));
	}
	
	@GetMapping("/buscar/nome")
	public ResponseEntity<List<Contato>> buscarContatoNome(@RequestBody String nome) throws ContatoException{
		return ResponseEntity.ok(contatoService.buscarContatoNome(nome));
	}
	
	@GetMapping("/buscar/sobrenome")
	public ResponseEntity<List<Contato>> buscarContatoSobreNome(@RequestBody String sobrenome) throws ContatoException{
		return ResponseEntity.ok(contatoService.buscarContatoSobreNome(sobrenome));
	}
	
	@GetMapping("/buscar/telefone")
	public ResponseEntity<List<Contato>> buscarContatoTelefone(@RequestBody String telefone) throws ContatoException{
		return ResponseEntity.ok(contatoService.buscarContatoTelefone(telefone));
	}
	
	@GetMapping("/buscar/email")
	public ResponseEntity<List<Contato>> buscarContatoEmail(@RequestBody String email) throws ContatoException{
		return ResponseEntity.ok(contatoService.buscarContatoEmail(email));
	}
	
	@GetMapping("/buscar/empresa")
	public ResponseEntity<List<Contato>> buscarContatoEmpresa(@RequestBody String empresa) throws ContatoException{
		return ResponseEntity.ok(contatoService.buscarContatoEmpresa(empresa));
	}
}
