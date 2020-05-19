package com.ras.persona.api;


import com.ras.persona.domain.pais.Pais;
import com.ras.persona.domain.pais.PaisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("countries")
class PaisResource {

    @Autowired
    private PaisRepository repository;

    @GetMapping
    public Iterable<Pais> listar() {
        return repository.findAll();
    }
}
