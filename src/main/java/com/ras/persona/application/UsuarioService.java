package com.ras.persona.application;

import com.ras.persona.domain.usuarios.Usuario;
import org.springframework.lang.NonNull;

import java.util.List;

public interface UsuarioService {
    Usuario obter(@NonNull final Long id);
    Usuario inserir(@NonNull final Usuario usuario);
    Usuario alterar(@NonNull final Usuario usuario);
    void deletar(@NonNull final Long id);
    List<Usuario> listar();
}
