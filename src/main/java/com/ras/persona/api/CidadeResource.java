package com.ras.persona.api;


import com.ras.persona.domain.cidades.Cidade;
import com.ras.persona.domain.cidades.CidadeRepository;
import com.ras.persona.domain.estados.Estado;
import com.ras.persona.domain.estados.EstadoRepository;
import com.ras.persona.domain.pais.Pais;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("cities")
class CidadeResource {

    @Autowired
    private CidadeRepository repository;

    @GetMapping
    public Iterable<Cidade> listar() {
        return repository.findAll();
    }

    @GetMapping("/states/{id}")
    public Iterable<Cidade> listarPorPais(Long id) {
        return repository.findByEstado(new Estado(id));
    }
}
