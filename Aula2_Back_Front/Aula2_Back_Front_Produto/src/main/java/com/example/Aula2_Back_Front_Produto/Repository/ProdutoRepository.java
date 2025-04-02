package com.example.Aula2_Back_Front_Produto.Repository;

import com.example.Aula2_Back_Front_Produto.Entity.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
}
