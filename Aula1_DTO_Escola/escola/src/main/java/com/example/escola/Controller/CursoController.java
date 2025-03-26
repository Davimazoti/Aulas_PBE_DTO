package com.example.escola.Controller;

import com.example.escola.Entity.Curso;
import com.example.escola.Entity.Professor;
import com.example.escola.Repository.CursoRepository;
import com.example.escola.Server.CursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/curso")
public class CursoController {
    @Autowired
    private CursoService cursoService;
}