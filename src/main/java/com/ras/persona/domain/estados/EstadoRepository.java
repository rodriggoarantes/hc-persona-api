package com.ras.persona.domain.estados;

import com.ras.persona.domain.pais.Pais;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface EstadoRepository extends CrudRepository<Estado, Long> {
    List<Estado> findByPais(Pais pais);
}
