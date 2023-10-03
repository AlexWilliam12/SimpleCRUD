package br.com.web_pi.ado1.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.web_pi.ado1.models.Aluno;

public interface AlunoRepository extends JpaRepository<Aluno, String>{
    
}
