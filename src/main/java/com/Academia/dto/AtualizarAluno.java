package com.Academia.dto;

import com.Academia.model.Aluno;

public record AtualizarAluno(Long id,
		String nome,
		String sobrenome,		
		String email,		
		String celular,		
		String dataMens,
		Double valorMensalidade,
		String status) {

	public AtualizarAluno(Aluno at) {
		this(
				at.getId(),
				at.getNome(),
				at.getSobrenome(),
				at.getEmail(),
				at.getCelular(),
				at.getDataMens(),
				at.getValorMensalidade(),
				at.getStatus());
	}

}
