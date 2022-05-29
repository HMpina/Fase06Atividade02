package com.traveller.services;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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

    public Page<AcomodacaoModel> findAll(Pageable pageable) {
        return acomodacaoRepository.findAll(pageable);
    }

    public Optional<AcomodacaoModel> findById(Long codAcomodacao) {
        return acomodacaoRepository.findById(codAcomodacao);
    }

    @Transactional
    public void delete(AcomodacaoModel acomodacaoModel) {
        acomodacaoRepository.delete(acomodacaoModel);
    }

	
	
}
