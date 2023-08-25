package com.laurp.intracampus.services;

import com.laurp.intracampus.Domain.Atleta;
import com.laurp.intracampus.Domain.Atletica;
import com.laurp.intracampus.repositories.AtleticaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AtleticaServiceImpl implements AtleticaService {
    @Autowired
    private final AtleticaRepository atleticaRepository;

    public AtleticaServiceImpl(AtleticaRepository atleticaRepository) {
        this.atleticaRepository = atleticaRepository;
    }

    @Override
    public List<Atletica> getAllAtleticas() {
        return atleticaRepository.findAll();
    }

    @Override
    public Atletica getAtleticaById(Long id) {
        return atleticaRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Atletica " + id + " not found!"));
    }

    @Override
    public Atletica createNewAtletica(Atletica atletica) {
        return atleticaRepository.save(atletica);
    }

    @Override
    public Atletica patchAtletica(Long id, Atletica atletica) {
        return atleticaRepository.findById(id).map(savedAtletica -> {
            if (atletica.getName() != null) {
                savedAtletica.setName(atletica.getName());
            }
            return atleticaRepository.save(savedAtletica);
        }).orElseThrow(() -> new ResourceNotFoundException("Atletica " + id + " not found!"));
    }

    @Override
    public void deleteAtletica(Long id) {
        atleticaRepository.deleteById(id);
    }

    @Override
    public List<Atleta> getAtletasByAtletica(Long id) {
        Atletica atletica = atleticaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Exposition " + id + " not found!"));
        return atletica.getAtletas();
    }
}
