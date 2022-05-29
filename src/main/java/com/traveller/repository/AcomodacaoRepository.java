package com.traveller.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.traveller.model.AcomodacaoModel;

@Repository
public interface AcomodacaoRepository extends JpaRepository<AcomodacaoModel, Long> {

	Optional<AcomodacaoModel> findById(Long codAcomodacao);

	
}
