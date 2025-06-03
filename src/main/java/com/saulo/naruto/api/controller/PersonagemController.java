package com.saulo.naruto.api.controller;

import com.saulo.naruto.api.model.Personagem;
import com.saulo.naruto.api.repository.PersonagemRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/personagens")
public class PersonagemController {

    private final PersonagemRepository repository;

    public PersonagemController(PersonagemRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<Personagem> getTodosPersonagens() {
        return repository.findAll();
    }

    @PostMapping
    public ResponseEntity<Personagem> criarPersonagem(@RequestBody Personagem personagem) {
        Personagem salvo = repository.save(personagem);
        URI location = URI.create("/personagens/" + salvo.getId());
        return ResponseEntity.created(location).body(salvo);
    }
}

