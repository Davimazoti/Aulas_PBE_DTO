package com.example.escola.Server;

import com.example.escola.DTO.ProfessorDTO;
import com.example.escola.Entity.Professor;
import com.example.escola.Repository.ProfessorRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class ProfessorService {

    @Autowired
    private ProfessorRepository professorRepository;

    public Professor fromDTO(ProfessorDTO professorDTO){
        Professor professor = new Professor();
        professor.setNome(professorDTO.getNome());
        professor.setCpf(professorDTO.getCpf());

        return professor;
    }

    public Professor save(ProfessorDTO professorDTO){
        Professor professor = this.fromDTO(professorDTO);
        Professor professorBd = professorRepository.save(professor);
        return professorBd;
    }
}
