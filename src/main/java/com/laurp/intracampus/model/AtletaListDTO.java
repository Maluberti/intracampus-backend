package com.laurp.intracampus.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class AtletaListDTO {
    List<AtletaDTO> atletas = null;

    public AtletaListDTO(List<AtletaDTO> atletas){this.atletas = atletas;}
}
