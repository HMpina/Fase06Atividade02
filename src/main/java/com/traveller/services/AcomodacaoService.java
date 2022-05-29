package com.traveller.services;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.traveller.model.Acomodacao;
import com.traveller.repository.AcomodacaoRepository;

@Service
public class AcomodacaoService {
	
    final AcomodacaoRepository acomodacaoRepository;

    public AcomodacaoService(AcomodacaoRepository acomodacaoRepository) {
        this.acomodacaoRepository = acomodacaoRepository;
    }

    @Transactional
    public Acomodacao save(Acomodacao acomodacao) {
        return acomodacaoRepository.save(acomodacao);
    }

    public Page<Acomodacao> findAll(Pageable pageable) {
        return acomodacaoRepository.findAll(pageable);
    }

    public Optional<Acomodacao> findById(Long codAcomodacao) {
        return acomodacaoRepository.findById(codAcomodacao);
    }

    @Transactional
    public void delete(Acomodacao acomodacao) {
        acomodacaoRepository.delete(acomodacao);
    }

	
	
}
