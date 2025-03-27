package com.example.Aula1_DTO_Escola.Service;


import com.example.Aula1_DTO_Escola.DTO.ProfessorDTO;
import com.example.Aula1_DTO_Escola.Entity.Professor;
import com.example.Aula1_DTO_Escola.Repository.ProfessorRepository;
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

    public ProfessorDTO toDTO(Professor professor){
        ProfessorDTO professorDTO = new ProfessorDTO();
        professorDTO.setId(professor.getIdProfessor());
        professorDTO.setNome(professor.getNome());
        professorDTO.setCpf(professor.getCpf());
        return professorDTO;
    }

    public ProfessorDTO save(ProfessorDTO professorDTO){
        Professor professor = this.fromDTO(professorDTO);
        Professor professorBd = professorRepository.save(professor);
        return this.toDTO(professorBd);
    }


}
