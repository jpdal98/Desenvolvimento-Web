package com.ufc.client.dto;

import java.io.Serializable;

import com.ufc.client.model.Client;

public class ClientDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String name;
	private String cpf;
	private Double income;
	private Integer age;
	private Integer childrean;
	
	public ClientDTO() {
	}
	public ClientDTO(Long id, String name, String cpf, Double income, Integer age, Integer childrean) {
		this.id = id;
		this.name = name;
		this.cpf = cpf;
		this.income = income;
		this.age = age;
		this.childrean = childrean;
	}

	public ClientDTO(Client entity) {
		this.id = entity.getId();
		this.name = entity.getName();
		this.cpf = entity.getCpf();
		this.income = entity.getIncome();
		this.age = entity.getAge();
		this.childrean = entity.getChildrean();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Double getIncome() {
		return income;
	}

	public void setIncome(Double income) {
		this.income = income;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Integer getChildrean() {
		return childrean;
	}

	public void setChildrean(Integer childrean) {
		this.childrean = childrean;
	}
}
