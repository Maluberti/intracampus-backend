package com.laurp.intracampus.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AtletaCreateDTO {
    private Long id;

    private String name;

    private String rg;

    private String cpf;

    private Long atleticaId;

    private Boolean formado;

}
