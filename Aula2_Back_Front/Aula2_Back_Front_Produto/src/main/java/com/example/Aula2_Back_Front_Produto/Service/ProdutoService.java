package com.example.Aula2_Back_Front_Produto.Service;

import com.example.Aula2_Back_Front_Produto.DTO.ProdutoDTO;
import com.example.Aula2_Back_Front_Produto.Entity.Produto;
import com.example.Aula2_Back_Front_Produto.Repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    public Produto fromDTO(ProdutoDTO produtoDTO){
        Produto produto = new Produto();
        produto.setNome(produtoDTO.getNome());
        produto.setValor(produtoDTO.getValor());
        produto.setSaldo(produtoDTO.getSaldo());
        produto.setSaldoMin(produtoDTO.getSaldoMin());

        return produto;
    }

    public ProdutoDTO toDTO(Produto produto){
        ProdutoDTO produtoDTO = new ProdutoDTO();
        produtoDTO.setNome(produto.getNome());
        produtoDTO.setValor(produto.getValor());
        produtoDTO.setSaldo(produto.getSaldo());
        produtoDTO.setSaldoMin(produto.getSaldoMin());

        return produtoDTO;
    }

    public List<Produto> getAll(){
        return produtoRepository.findAll();
    }

    public ProdutoDTO saveDTO(ProdutoDTO produtoDTO){
        Produto produto = this.fromDTO(produtoDTO);
        Produto produtoBd = produtoRepository.save(produto);
        return this.toDTO(produtoBd);
    }
}
