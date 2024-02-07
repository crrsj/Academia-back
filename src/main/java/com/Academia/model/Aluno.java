package com.Academia.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


import com.Academia.dto.AtualizarAluno;
import com.Academia.dto.CadastrarAluno;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;



@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "alunos")
public class Aluno {     
	
	@Id
    @GeneratedValue(strategy  = GenerationType.IDENTITY)
	private Long id;
    @NotBlank
	private String nome;
    @NotBlank
	private String sobrenome;
	private String cpf;
	private String email;
	private String sexo;
	@NotBlank	
	private String celular;		
	private String dataNasc = LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));		
	private String dataMens = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
	@NotNull
	private Double valorMensalidade;
	private String status;
	
	public Aluno(CadastrarAluno cadastro) {
		this.nome  = cadastro.nome();
		this.sobrenome = cadastro.sobrenome();
		this.cpf = cadastro.cpf();
		this.email = cadastro.email();
		this.sexo = cadastro.sexo();
		this.celular = cadastro.celular();
		this.dataNasc = cadastro.dataNasc();
		this.dataMens = cadastro.dataMens();
		this.valorMensalidade = cadastro.valorMensalidade();
		this.status = cadastro.status();
		
	}

	public void atualizando(AtualizarAluno atualize) {
		if(atualize.nome() != null) {
			this.nome = atualize.nome();
		}
		if(atualize.sobrenome() != null) {
			this.sobrenome = atualize.sobrenome();
		}
		if(atualize.email() != null) {
			this.email = atualize.email();
		}
		if(atualize.celular() != null) {
			this.celular = atualize.celular();
		}
		if(atualize.dataMens() != null) {
			this.dataMens = atualize.dataMens();
		}
		if(atualize.valorMensalidade() != null) {
			this.valorMensalidade = atualize.valorMensalidade();
		}
		if(atualize.status() != null) {
			this.status = atualize.status();
		}
	}
}
