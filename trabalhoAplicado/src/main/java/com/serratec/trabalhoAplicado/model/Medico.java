package com.serratec.trabalhoAplicado.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "medico")
@SequenceGenerator(name = "generator_usuario", sequenceName = "sequence_usuario", initialValue = 1, allocationSize = 1)
public class Medico extends Usuario{

	public  Medico(String email, String username, String senha, String nome, String cpf ,String telefone) {
		super();
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "generator_usuario")
	private Long id;
	
	@Column(nullable = true, length = 60, unique = true)
	private String crn;
	
	
	public Medico() {}
	
	public String getCrn() {
		return crn;
	}
	public void setCrn(String crn) {
		this.crn = crn;
	}

}