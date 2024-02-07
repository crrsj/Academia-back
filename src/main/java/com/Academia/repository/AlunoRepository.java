package com.Academia.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Academia.model.Aluno;

public interface AlunoRepository extends JpaRepository<Aluno, Long>{

}
