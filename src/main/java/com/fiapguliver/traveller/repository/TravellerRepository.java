package com.fiapguliver.traveller.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fiapguliver.traveller.model.Traveller;

public interface TravellerRepository extends JpaRepository<Traveller, Long> {

}
