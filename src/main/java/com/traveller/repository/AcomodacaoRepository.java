package com.traveller.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.traveller.model.Acomodacao;

@Repository
public interface AcomodacaoRepository extends JpaRepository<Acomodacao, Long> {

	Optional<Acomodacao> findById(Long codAcomodacao);

	
}
