package com.traveller.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.traveller.model.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {

}
