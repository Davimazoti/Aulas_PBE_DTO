package com.example.escola.Controller;

import com.example.escola.DTO.ProfessorDTO;
import com.example.escola.Entity.Professor;
import com.example.escola.Service.ProfessorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/professor")
public class ProfessorController {

    @Autowired
    private ProfessorService professorService;

    @PostMapping
    public ResponseEntity<ProfessorDTO> create(@RequestBody ProfessorDTO professorDTO){
        Professor professor = professorService.save(professorDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(professor);
    }
}