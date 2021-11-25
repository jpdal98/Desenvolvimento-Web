package br.com.ufc.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "proprietario")
public class Proprietario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String nome;
	private String telefone;
	private String email;
	
	
	@OneToMany(mappedBy = "proprietario")
	private List<Veiculo> veiculo;
	
	
	public Proprietario(){
		veiculo = new ArrayList<Veiculo>();
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public List<Veiculo> getVeiculo() {
		return veiculo;
	}
	public void setVeiculo(List<Veiculo> veiculo) {
		this.veiculo = veiculo;
	}
	
	
	
	
	
	

}
