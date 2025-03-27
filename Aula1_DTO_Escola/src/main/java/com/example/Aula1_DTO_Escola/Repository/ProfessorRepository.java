package com.example.Aula1_DTO_Escola.Repository;

import com.example.Aula1_DTO_Escola.Entity.Professor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProfessorRepository extends JpaRepository<Professor, Long> {
}
