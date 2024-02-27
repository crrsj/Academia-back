package com.Academia.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Academia.dto.AtualizarAluno;
import com.Academia.dto.BuscarAluno;
import com.Academia.dto.CadastrarAluno;
import com.Academia.service.AlunoService;



@RestController
@RequestMapping("aluno")
@CrossOrigin(origins = "*")
public class AlunoController {
	
	@Autowired
	private AlunoService service;
	
	@PostMapping("cadastro")
	public ResponseEntity<CadastrarAluno>cadastrar(@RequestBody CadastrarAluno cadastro){
		var cadastre = service.cadastrar(cadastro);
		return new ResponseEntity<CadastrarAluno>(cadastre,HttpStatus.CREATED);
		
	}
	@GetMapping("busca") 
    public ResponseEntity<Iterable<BuscarAluno>>buscar(){
	   var busque = service.buscar();
	   return new ResponseEntity<Iterable<BuscarAluno>>(busque,HttpStatus.OK);
   }
	
	@DeleteMapping("deletar/{id}")
	public ResponseEntity<Void>deletar(@PathVariable Long id){
		 service.excluir(id);
		 return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		
	}
	@GetMapping("buscar/{id}")
	public ResponseEntity<BuscarAluno>buscaId(@PathVariable Long id){
		var buscaId = service.buscarId(id);
		return new ResponseEntity<BuscarAluno>(buscaId,HttpStatus.OK);
		
	}
	@PutMapping("atualiza")
	public ResponseEntity<AtualizarAluno>atualizarAluno(@RequestBody AtualizarAluno cadastro){		
		var cadastre =  service.atualizar(cadastro);
		return ResponseEntity.ok(cadastre);
		
	}	
	

	
}