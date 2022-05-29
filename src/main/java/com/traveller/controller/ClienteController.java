package com.traveller.controller;

import java.util.Optional;

import javax.validation.Valid;

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

import com.traveller.model.ClienteModel;
import com.traveller.services.ClienteService;


@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/cliente")
public class ClienteController {

    final ClienteService clienteService;

    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @PostMapping
    public ResponseEntity<Object> saveCliente(@RequestBody @Valid ClienteModel clienteModel){

        return ResponseEntity.status(HttpStatus.CREATED).body(clienteService.save(clienteModel));
    }

    @GetMapping
    public ResponseEntity<Page<ClienteModel>> getAllParkingSpots(@PageableDefault(page = 0, size = 10, sort = "codCliente", direction = Sort.Direction.ASC) Pageable pageable){
        return ResponseEntity.status(HttpStatus.OK).body(clienteService.findAll(pageable));
    }

    @GetMapping("/{codCliente}")
    public ResponseEntity<Object> getOneParkingSpot(@PathVariable(value = "codCliente") Long codCliente){
        Optional<ClienteModel> clienteOptional = clienteService.findById(codCliente);
        if (!clienteOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Parking Spot not found.");
        }
        return ResponseEntity.status(HttpStatus.OK).body(clienteOptional.get());
    }

    @DeleteMapping("/{codCliente}")
    public ResponseEntity<Object> deleteParkingSpot(@PathVariable(value = "codCliente") Long codCliente){
        Optional<ClienteModel> clienteOptional = clienteService.findById(codCliente);
        if (!clienteOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Parking Spot not found.");
        }
        clienteService.delete(clienteOptional.get());
        return ResponseEntity.status(HttpStatus.OK).body("Parking Spot deleted successfully.");
    }

    @PutMapping("/{codCliente}")
    public ResponseEntity<Object> updateParkingSpot(@PathVariable(value = "codCliente") Long codCliente,
                                                    @RequestBody @Valid ClienteModel clienteModel){
        Optional<ClienteModel> clienteOptional = clienteService.findById(codCliente);
        if (!clienteOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Parking Spot not found.");
        }
                clienteModel.setCodCliente(clienteOptional.get().getCodCliente());
                return ResponseEntity.status(HttpStatus.OK).body(clienteService.save(clienteModel));
    }



}
