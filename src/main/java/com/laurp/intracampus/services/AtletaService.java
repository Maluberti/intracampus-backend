package com.laurp.intracampus.services;


import com.laurp.intracampus.Domain.Atleta;

import java.util.List;


public interface AtletaService {
    List<Atleta> getAllAtletas();

    Atleta getAtletaById(Long id);

    Atleta createNewAtleta(Atleta atleta);

    Atleta patchAtleta(Long id, Atleta atleta);

    void deleteAtleta(Long id);
}
