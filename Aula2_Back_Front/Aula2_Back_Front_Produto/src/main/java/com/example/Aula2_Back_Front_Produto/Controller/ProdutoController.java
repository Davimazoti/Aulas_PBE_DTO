package com.example.Aula2_Back_Front_Produto.Controller;

import com.example.Aula2_Back_Front_Produto.DTO.ProdutoDTO;
import com.example.Aula2_Back_Front_Produto.Entity.Produto;
import com.example.Aula2_Back_Front_Produto.Repository.ProdutoRepository;
import com.example.Aula2_Back_Front_Produto.Service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produto")
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    @GetMapping
    public ResponseEntity<List<Produto>> getAll(){
        return ResponseEntity.status(HttpStatus.OK).body(produtoService.getAll());
    }

    @PostMapping
    public ResponseEntity<ProdutoDTO> created(@RequestBody ProdutoDTO produtoDTO){
        ProdutoDTO produto = produtoService.saveDTO(produtoDTO);
        return  ResponseEntity.status(HttpStatus.CREATED).body(produto);
    }
}
