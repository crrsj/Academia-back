package com.Academia.dto;

import com.Academia.model.Aluno;

public record BuscarAluno(
		Long id,
		String nome,
		String sobrenome,		
		String email,		
		String celular,		
		String dataMens,
		Double valorMensalidade,
		String status) {
       
	public BuscarAluno(Aluno aluno) {
		this(
				aluno.getId(),
				aluno.getNome(),
				aluno.getSobrenome(),				
				aluno.getEmail(),				
				aluno.getCelular(),
				aluno.getDataMens(),
				aluno.getValorMensalidade(),
				aluno.getStatus());
	}
}
