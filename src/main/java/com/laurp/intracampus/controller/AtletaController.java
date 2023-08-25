package com.laurp.intracampus.controller;

import com.laurp.intracampus.Domain.Atleta;
import com.laurp.intracampus.mapper.AtletaMapper;
import com.laurp.intracampus.model.AtletaCreateDTO;
import com.laurp.intracampus.model.AtletaDTO;
import com.laurp.intracampus.model.AtletaListDTO;
import com.laurp.intracampus.services.AtletaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.stream.Collectors;

@RestController
@RequestMapping(AtletaController.BASE_URL)
@Tag(name = "Atleta")

public class AtletaController {
    public static final String BASE_URL = "/atleta";
    private final AtletaService atletaService;
    private final AtletaMapper atletaMapper;

    public AtletaController(AtletaService atletaService, AtletaMapper atletaMapper) {
        this.atletaService = atletaService;
        this.atletaMapper = atletaMapper;
    }


    @Operation(summary = "Return a list of Atletas")
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public AtletaListDTO getListOfAtletas()
    {
        return new AtletaListDTO(atletaService.getAllAtletas()
                .stream()
                .map(this::toDTO)
                .collect(Collectors.toList()));
    }


    @Operation(summary = "Return a atleta by its id")
    @GetMapping({"/{id}"})
    @ResponseStatus(HttpStatus.OK)
    public AtletaDTO getAtletaById(@PathVariable Long id){
        return toDTO(atletaService.getAtletaById(id));
    }

    @Operation(summary = "Create new Atleta")
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public AtletaDTO createNewAtleta(@RequestBody AtletaCreateDTO atletaDTO){
        return toDTO(atletaService.createNewAtleta(toEntity(atletaDTO)));
    }

    @Operation(summary = "Patch an Atleta")
    @PatchMapping({"/{id}"})
    @ResponseStatus(HttpStatus.OK)
    public AtletaDTO patchAtleta(@PathVariable Long id, @RequestBody AtletaCreateDTO atletaDTO){
        return toDTO(atletaService.patchAtleta(id, toEntity(atletaDTO)));
    }

    @Operation(summary = "Delete a Atleta")
    @DeleteMapping({"/{id}"})
    @ResponseStatus(HttpStatus.OK)
    public void deleteAtleta(@PathVariable Long id){
        atletaService.deleteAtleta(id);
    }

    // aux methods
    private String getAtletaUrl(Long id) {
        return AtletaController.BASE_URL + "/" + id;
    }

    private AtletaDTO toDTO (Atleta atleta){
        AtletaDTO atletaDTO = atletaMapper.toDTO(atleta);
        atletaDTO.setAtletaUrl(getAtletaUrl(atleta.getId()));
        return atletaDTO;
    }

    private Atleta toEntity(AtletaCreateDTO atletaDTO) {return atletaMapper.toEntity(atletaDTO);}



}
