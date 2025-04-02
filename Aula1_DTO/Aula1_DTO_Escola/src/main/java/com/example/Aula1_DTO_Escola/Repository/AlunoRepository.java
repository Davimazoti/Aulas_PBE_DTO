package com.example.Aula1_DTO_Escola.Repository;

import com.example.Aula1_DTO_Escola.Entity.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlunoRepository extends JpaRepository<Aluno, Long> {
}
