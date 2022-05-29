package com.traveller.services;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.traveller.model.AcomodacaoModel;
import com.traveller.repository.AcomodacaoRepository;

@Service
public class AcomodacaoService {
	
    final AcomodacaoRepository acomodacaoRepository;

    public AcomodacaoService(AcomodacaoRepository acomodacaoRepository) {
        this.acomodacaoRepository = acomodacaoRepository;
    }

    @Transactional
    public AcomodacaoModel save(AcomodacaoModel acomodacaoModel) {
        return acomodacaoRepository.save(acomodacaoModel);
    }

    public List<AcomodacaoModel> findAll() {
        return acomodacaoRepository.findAll();
    }

    public Optional<AcomodacaoModel> findById(Long codAcomodacao) {
        return acomodacaoRepository.findById(codAcomodacao);
    }

    @Transactional
    public void delete(AcomodacaoModel acomodacaoModel) {
        acomodacaoRepository.delete(acomodacaoModel);
    }

	
	
}
