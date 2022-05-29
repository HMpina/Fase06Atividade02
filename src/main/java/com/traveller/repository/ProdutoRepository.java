package com.traveller.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.traveller.model.Produto;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {

}
