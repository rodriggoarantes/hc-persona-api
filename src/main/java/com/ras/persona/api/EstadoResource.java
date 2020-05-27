package com.ras.persona.api;


import com.ras.persona.domain.estados.Estado;
import com.ras.persona.domain.estados.EstadoRepository;
import com.ras.persona.domain.pais.Pais;
import com.ras.persona.domain.pais.PaisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("states")
class EstadoResource {

    @Autowired
    private EstadoRepository repository;

    @GetMapping
    public Iterable<Estado> listar() {
        return repository.findAll();
    }

    @GetMapping("/countries/{id}")
    public Iterable<Estado> listarPorPais(Long id) {
        return repository.findByPais(new Pais(id));
    }
}
