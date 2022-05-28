package com.traveller.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.traveller.model.Traveller;

public interface TravellerRepository extends JpaRepository<Traveller, Long> {

}

