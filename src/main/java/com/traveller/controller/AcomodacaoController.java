package com.traveller.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.traveller.model.AcomodacaoModel;
import com.traveller.repository.AcomodacaoRepository;
//import com.traveller.services.AcomodacaoService;


@Controller
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/acomodacao")
public class AcomodacaoController {

	@Autowired
    private AcomodacaoRepository acomodacaoRepository;

    @PostMapping
    public ResponseEntity<Object> saveAcomodacao(@RequestBody AcomodacaoModel acomodacaoModel){

        return ResponseEntity.status(HttpStatus.CREATED).body(acomodacaoRepository.save(acomodacaoModel));
    }

    @GetMapping("/listaAcomodacao")
	public String listaAcomodacao(ModelMap model) {
		List<AcomodacaoModel> lista = acomodacaoRepository.findAll();
		model.addAttribute("listaAcomodacao", lista);	
		return "listaAcomodacao";
    }

    @GetMapping("/{codAcomocadao}")
    public ResponseEntity<Object> getOneAcomodacao(@PathVariable(value = "codAcomocadao") Long codAcomocadao){
        Optional<AcomodacaoModel> acomodacaoOptional = acomodacaoRepository.findById(codAcomocadao);
        if (!acomodacaoOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Acomodação não encontrada.");
        }
        return ResponseEntity.status(HttpStatus.OK).body(acomodacaoOptional.get());
    }

    @DeleteMapping("/{codAcomocadao}")
    public ResponseEntity<Object> deleteAcomodacao(@PathVariable(value = "codAcomocadao") Long codAcomocadao){
        Optional<AcomodacaoModel> acomodacaoOptional = acomodacaoRepository.findById(codAcomocadao);
        if (!acomodacaoOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Acomodação não encontrada.");
        }
        acomodacaoRepository.delete(acomodacaoOptional.get());
        return ResponseEntity.status(HttpStatus.OK).body("Acomodação deletada com sucesso.");
    }

    @PutMapping("/{codAcomocadao}")
    public ResponseEntity<Object> updateAcomodacao(@PathVariable(value = "codAcomocadao") Long codAcomocadao,
                                                    @RequestBody @Valid AcomodacaoModel acomodacaoModel){
        Optional<AcomodacaoModel> acomodacaoOptional = acomodacaoRepository.findById(codAcomocadao);
        if (!acomodacaoOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Acomodação NÃO ENCONTRADA.");
        }
                acomodacaoModel.setCodAcomodacao(acomodacaoOptional.get().getCodAcomodacao());
                return ResponseEntity.status(HttpStatus.OK).body(acomodacaoRepository.save(acomodacaoModel));
    }



}
