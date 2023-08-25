package com.laurp.intracampus.services;

import com.laurp.intracampus.Domain.Atleta;
import com.laurp.intracampus.model.AtletaListDTO;
import com.laurp.intracampus.repositories.AtletaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AtletaServiceImpl implements AtletaService{
    @Autowired
    private final AtletaRepository atletaRepository;

    public AtletaServiceImpl(AtletaRepository atletaRepository) {
        this.atletaRepository = atletaRepository;
    }


    @Override
    public List<Atleta> getAllAtletas() {
        return atletaRepository.findAll();
    }

    @Override
    public Atleta getAtletaById(Long id) {
        return atletaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Atleta " + id + " not found!"));
    }


    @Override
    public Atleta createNewAtleta(Atleta atleta) {
        return atletaRepository.save(atleta);
    }

    @Override
    public Atleta patchAtleta(Long id, Atleta atleta) {
        return atletaRepository.findById(id).map(savedAtleta -> {

            if (atleta.getName() != null) {
                savedAtleta.setName(atleta.getName());
            }
            if (atleta.getId() != null) {
                savedAtleta.setId(atleta.getId());
            }
            if (atleta.getRg() != null) {
                savedAtleta.setRg(atleta.getRg());
            }
            if (atleta.getCpf() != null) {
                savedAtleta.setCpf(atleta.getCpf());
            }
            if (atleta.getAtletica() != null) {
                savedAtleta.setAtletica(atleta.getAtletica());
            }

            return atletaRepository.save(savedAtleta);

        }).orElseThrow(() -> new ResourceNotFoundException("Atleta " + id + " not found!"));
    }

    @Override
    public void deleteAtleta(Long id) {
        atletaRepository.deleteById(id);
    }

}
