package com.example.escola.Controller;

import com.example.escola.DTO.ProfessorDTO;
import com.example.escola.Entity.Professor;
import com.example.escola.Repository.ProfessorRepository;
import com.example.escola.Server.ProfessorService;
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

    @PostMapping
    public ResponseEntity<Professor> create(@RequestBody ProfessorDTO professorDTO){
        Professor professorBd = professorService.save(professorDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(professorBd);
    }
}