package com.Academia.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Academia.dto.AtualizarAluno;
import com.Academia.dto.BuscarAluno;
import com.Academia.dto.CadastrarAluno;
import com.Academia.model.Aluno;
import com.Academia.repository.AlunoRepository;

@Service
public class AlunoService {
	
	@Autowired
	private AlunoRepository repository;
	
	public CadastrarAluno cadastrar(CadastrarAluno cadastro) {
		
		var aluno = new Aluno(cadastro);
		 var cad =  repository.save(aluno);
		 return new  CadastrarAluno(cad); 
		
	}
	public Iterable<BuscarAluno>buscar(){
		var busca = repository.findAll().stream().map(BuscarAluno::new).toList();
		return busca;
 }
	public AtualizarAluno atualizar(AtualizarAluno atualize) {
		var at = repository.getReferenceById(atualize.id());
		at.atualizando(atualize);
		return new AtualizarAluno(at);
	}
	public  void excluir(Long id) {
		repository.deleteById(id);
		
	}
	public BuscarAluno buscarId(Long id) {
		var buscaAluno = repository.findById(id).get();
		return new BuscarAluno(buscaAluno);
		
	}
}