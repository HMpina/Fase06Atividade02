package com.traveller.services;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.traveller.model.ClienteModel;
import com.traveller.repository.ClienteRepository;

@Service
public class ClienteService {
	
    final ClienteRepository clienteRepository;

    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    @Transactional
    public ClienteModel save(ClienteModel clienteModel) {
        return clienteRepository.save(clienteModel);
    }

    public Page<ClienteModel> findAll(Pageable pageable) {
        return clienteRepository.findAll(pageable);
    }

    public Optional<ClienteModel> findById(Long clienteAcomodacao) {
        return clienteRepository.findById(clienteAcomodacao);
    }

    @Transactional
    public void delete(ClienteModel clienteModel) {
        clienteRepository.delete(clienteModel);
    }

	
}
