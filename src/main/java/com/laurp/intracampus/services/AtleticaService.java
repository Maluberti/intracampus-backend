package com.laurp.intracampus.services;

import com.laurp.intracampus.Domain.Atleta;
import com.laurp.intracampus.Domain.Atletica;

import java.util.List;

public interface AtleticaService {
    List<Atletica> getAllAtleticas();

    Atletica getAtleticaById(Long id);

    Atletica createNewAtletica(Atletica atletica);

    Atletica patchAtletica(Long id, Atletica atletica);

    void deleteAtletica(Long id);

    List<Atleta> getAtletasByAtletica(Long id);
}
