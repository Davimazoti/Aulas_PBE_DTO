package com.example.Aula1_DTO_Escola.Controller;

import com.example.Aula1_DTO_Escola.DTO.ProfessorDTO;
import com.example.Aula1_DTO_Escola.Entity.Professor;
import com.example.Aula1_DTO_Escola.Service.ProfessorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/professor")
public class ProfessorController {

    @Autowired
    private ProfessorService professorService;

    @GetMapping("/mostrarTudo")
    public ResponseEntity<List<Professor>> getAll(){
        return ResponseEntity.status(HttpStatus.OK).body(professorService.getAll());
    }

    @GetMapping("/procurar/{id}")
    public ResponseEntity<ProfessorDTO> getById(@PathVariable Long id){
        Optional<ProfessorDTO> professorDTO = professorService.getById(id);
        if(professorDTO.isPresent()){
            return ResponseEntity.ok(professorDTO.get());
        }else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

//        return professorDTO.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/adicionar")
    public ResponseEntity<ProfessorDTO> created(@RequestBody ProfessorDTO professorDto){
        ProfessorDTO professor = professorService.save(professorDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(professor);
    }

    @PutMapping("/alterar/{id}")
    public ResponseEntity<ProfessorDTO> update(@PathVariable Long id, @RequestBody ProfessorDTO professorDTO){
        Optional<ProfessorDTO> professorDTOOptional = professorService.updateProfessor(id, professorDTO);
        if (professorDTOOptional.isPresent()){
            return ResponseEntity.ok(professorDTOOptional.get());
        }else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        if(professorService.delete(id)){
            return ResponseEntity.noContent().build();
        }else {
            return ResponseEntity.notFound().build();
        }
    }
}