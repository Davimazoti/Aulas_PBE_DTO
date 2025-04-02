package com.example.Aula1_DTO_Escola.Repository;

import com.example.Aula1_DTO_Escola.Entity.Curso;
import org.apache.catalina.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CursoRepository extends JpaRepository<Curso, Long> {
}
