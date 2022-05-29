package com.traveller.controller;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.traveller.dtos.AcomodacaoDto;
import com.traveller.model.Acomodacao;
import com.traveller.services.AcomodacaoService;


@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/acomodacao")
public class TestController {

    final AcomodacaoService acomodacaoService;

    public TestController(AcomodacaoService acomodacaoService) {
        this.acomodacaoService = acomodacaoService;
    }

    @PostMapping
    public ResponseEntity<Object> saveAcomodacao(@RequestBody @Valid AcomodacaoDto acomodacaoDto){
    	Acomodacao acomodacao = new Acomodacao();
        BeanUtils.copyProperties(acomodacaoDto, acomodacao);
        return ResponseEntity.status(HttpStatus.CREATED).body(acomodacaoService.save(acomodacao));
    }

    @GetMapping
    public ResponseEntity<Page<Acomodacao>> getAllParkingSpots(@PageableDefault(page = 0, size = 10, sort = "id", direction = Sort.Direction.ASC) Pageable pageable){
        return ResponseEntity.status(HttpStatus.OK).body(acomodacaoService.findAll(pageable));
    }

    @GetMapping("/{codAcomocadao}")
    public ResponseEntity<Object> getOneParkingSpot(@PathVariable(value = "codAcomocadao") Long codAcomocadao){
        Optional<Acomodacao> acomodacaoOptional = acomodacaoService.findById(codAcomocadao);
        if (!acomodacaoOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Parking Spot not found.");
        }
        return ResponseEntity.status(HttpStatus.OK).body(acomodacaoOptional.get());
    }

    @DeleteMapping("/{codAcomocadao}")
    public ResponseEntity<Object> deleteParkingSpot(@PathVariable(value = "codAcomocadao") Long codAcomocadao){
        Optional<Acomodacao> acomodacaoOptional = acomodacaoService.findById(codAcomocadao);
        if (!acomodacaoOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Parking Spot not found.");
        }
        acomodacaoService.delete(acomodacaoOptional.get());
        return ResponseEntity.status(HttpStatus.OK).body("Parking Spot deleted successfully.");
    }

    @PutMapping("/{codAcomocadao}")
    public ResponseEntity<Object> updateParkingSpot(@PathVariable(value = "codAcomocadao") Long codAcomocadao,
                                                    @RequestBody @Valid AcomodacaoDto acomodacaoDto){
        Optional<Acomodacao> acomodacaoOptional = acomodacaoService.findById(codAcomocadao);
        if (!acomodacaoOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Parking Spot not found.");
        }
        Acomodacao acomodacao = new Acomodacao();
        BeanUtils.copyProperties(acomodacaoDto, acomodacao);
        acomodacao.setCodAcomodacao(acomodacaoOptional.get().getCodAcomodacao());
                return ResponseEntity.status(HttpStatus.OK).body(acomodacaoService.save(acomodacao));
    }



}
