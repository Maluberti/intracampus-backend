package com.laurp.intracampus.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.laurp.intracampus.Domain.Atletica;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AtletaDTO {
    private Long id;

    private String name;

    private String rg;

    private String cpf;

    private String atleticaName;

    private Boolean formado;

    @JsonProperty("atleta_url")
    private String atletaUrl;
}
