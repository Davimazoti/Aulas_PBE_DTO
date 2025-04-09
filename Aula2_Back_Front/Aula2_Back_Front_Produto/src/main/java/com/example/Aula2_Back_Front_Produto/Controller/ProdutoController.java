package com.example.Aula2_Back_Front_Produto.Controller;

import com.example.Aula2_Back_Front_Produto.DTO.ProdutoDTO;
import com.example.Aula2_Back_Front_Produto.Entity.Produto;
import com.example.Aula2_Back_Front_Produto.Repository.ProdutoRepository;
import com.example.Aula2_Back_Front_Produto.Service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/produto")
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    @GetMapping("/buscar")
    public ResponseEntity<List<Produto>> getAll(){
        return ResponseEntity.status(HttpStatus.OK).body(produtoService.getAll());
    }

    @PostMapping("/adicionar")
    public ResponseEntity<ProdutoDTO> created(@RequestBody ProdutoDTO produtoDTO){
        ProdutoDTO produto = produtoService.saveDTO(produtoDTO);
        return  ResponseEntity.status(HttpStatus.CREATED).body(produto);
    }

    @GetMapping("/buscar/{id}")
    public ResponseEntity<ProdutoDTO> getById(@PathVariable Long id){

        Optional<ProdutoDTO> produtoDTO = produtoService.getById(id);
        if (produtoDTO.isPresent()){
            return ResponseEntity.ok(produtoDTO.get());
        } else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @PutMapping("/atualizar/{id}")
    public ResponseEntity<ProdutoDTO> update(@PathVariable Long id, @RequestBody ProdutoDTO produtoDTO){
        Optional<ProdutoDTO> produtoDTOOptional = produtoService.updateProduto(id, produtoDTO);
        if (produtoDTOOptional.isPresent()){
            return ResponseEntity.ok(produtoDTOOptional.get());
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        if (produtoService.delete(id)){
            return ResponseEntity.noContent().build();
        }
        else {
            return ResponseEntity.notFound().build();
        }
    }
}
