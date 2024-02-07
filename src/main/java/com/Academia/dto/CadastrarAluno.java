package com.Academia.dto;

import com.Academia.model.Aluno;

public record CadastrarAluno(		
		String nome,
		String sobrenome,
		String cpf,
		String email,
		String sexo,
		String celular,
		String dataNasc,
		String dataMens,
		Double valorMensalidade,
		String status) {

	public CadastrarAluno(Aluno cad) {
		this(
				cad.getNome(),
				cad.getSobrenome(),
				cad.getCpf(),cad.getEmail(),
				cad.getSexo(),cad.getCelular(),
				cad.getDataNasc(),cad.getDataMens(),
				cad.getValorMensalidade(),
				cad.getStatus());
	}

}
