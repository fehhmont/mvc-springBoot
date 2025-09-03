package com.mvc.boot.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@SuppressWarnings({ "serial", "hiding" })
@Entity
@Table(name= "CARGOS")
public class Cargo extends AbstractEntity<Long> {

	@Column(name= "nome", nullable = false, unique = true, length = 60)
	private String nome;
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@ManyToOne
	@JoinColumn(name= "id_departamento_fk")
	private Departamento departamento;

	@OneToMany(mappedBy = "cargo")
	private java.util.List<Funcionario> funcionarios;

	public java.util.List<Funcionario> getFuncionarios() {
		return funcionarios;
	}

	public void setFuncionarios(java.util.List<Funcionario> funcionarios) {
		this.funcionarios = funcionarios;
	}

	public Departamento getDepartamento() {
		return departamento;
	}

	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}

	
}

