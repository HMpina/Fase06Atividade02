package com.traveller.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.traveller.model.Traveller;

@Repository
public interface TravellerRepository extends JpaRepository<Traveller, Long> {

}

