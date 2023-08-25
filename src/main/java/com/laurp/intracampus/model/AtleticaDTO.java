package com.laurp.intracampus.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AtleticaDTO {
    private Long id;
    private String name;

    @JsonProperty("atletica_url")
    private String atleticaUrl;
}
