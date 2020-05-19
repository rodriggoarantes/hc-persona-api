package com.ras.persona.domain.cidades;

import com.ras.persona.domain.estados.Estado;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CidadeRepository extends CrudRepository<Cidade, Long> {
    List<Cidade> findByEstado(Estado estado);
}
