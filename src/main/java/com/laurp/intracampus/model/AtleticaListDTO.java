package com.laurp.intracampus.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class AtleticaListDTO {
    List<AtleticaDTO> atleticas = null;

    public AtleticaListDTO(List<AtleticaDTO> atleticas){this.atleticas = atleticas;}
}
