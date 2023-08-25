package com.laurp.intracampus.controller;

import com.laurp.intracampus.Domain.Atletica;
import com.laurp.intracampus.mapper.AtletaMapper;
import com.laurp.intracampus.mapper.AtleticaMapper;
import com.laurp.intracampus.model.*;
import com.laurp.intracampus.services.AtleticaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.stream.Collectors;

@RestController
@RequestMapping(AtleticaController.BASE_URL)
@Tag(name = "Atletica")
public class AtleticaController {
    public static final String BASE_URL = "/atletica";
    private final AtleticaService atleticaService;
    private final AtleticaMapper atleticaMapper;
    private final AtletaMapper atletaMapper;

    public AtleticaController(AtleticaService atleticaService, AtleticaMapper atleticaMapper, AtletaMapper atletaMapper) {
        this.atleticaService = atleticaService;
        this.atleticaMapper = atleticaMapper;
        this.atletaMapper = atletaMapper;
    }


    @Operation(summary = "Return a list of Atleticas")
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public AtleticaListDTO getListOfAtleticas()
    {
        return new AtleticaListDTO(atleticaService.getAllAtleticas()
                .stream()
                .map(this::toDTO)
                .collect(Collectors.toList()));
    }


    @Operation(summary = "Return a Atletica")
    @GetMapping({"/{id}"})
    @ResponseStatus(HttpStatus.OK)
    public AtleticaDTO getAtleticaById(@PathVariable Long id){
        return toDTO(atleticaService.getAtleticaById(id));
    }

    @Operation(summary = "Return a list of atletas in Atletica")
    @GetMapping({"/{id}/atletas"})
    @ResponseStatus(HttpStatus.OK)
    public AtletaListDTO getAtletasByAtletica(@PathVariable Long id){
        return new AtletaListDTO( atleticaService.getAtletasByAtletica(id)
                .stream()
                .map(atletas -> {
                    AtletaDTO atletaDTO = atletaMapper.toDTO(atletas);
                    atletaDTO.setAtletaUrl(AtleticaController.BASE_URL + "/" + id + "/" + "atletas");
                    return atletaDTO;
                })
                .collect(Collectors.toList()));
    }

    @Operation(summary = "Create new Atletica")
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public AtleticaDTO createNewAtletica(@RequestBody AtleticaCreateDTO atleticaDTO){
        return toDTO(atleticaService.createNewAtletica(toEntity(atleticaDTO)));
    }

    @Operation(summary = "Patch an Atletica")
    @PatchMapping({"/{id}"})
    @ResponseStatus(HttpStatus.OK)
    public AtleticaDTO patchAtletica(@PathVariable Long id, @RequestBody AtleticaCreateDTO atleticaDTO){
        return toDTO(atleticaService.patchAtletica(id, toEntity(atleticaDTO)));
    }

    @Operation(summary = "Delete a Atletica")
    @DeleteMapping({"/{id}"})
    @ResponseStatus(HttpStatus.OK)
    public void deleteAtletica(@PathVariable Long id){
        atleticaService.deleteAtletica(id);
    }



    // aux methods
    private String getAtleticaUrl(Long id) {
        return AtleticaController.BASE_URL + "/" + id;
    }

    private AtleticaDTO toDTO (Atletica atletica){
        AtleticaDTO atleticaDTO = atleticaMapper.toDTO(atletica);
        atleticaDTO.setAtleticaUrl(getAtleticaUrl(atletica.getId()));
        return atleticaDTO;
    }

    private Atletica toEntity(AtleticaCreateDTO atleticaDTO) {return atleticaMapper.toEntity(atleticaDTO);}

}
