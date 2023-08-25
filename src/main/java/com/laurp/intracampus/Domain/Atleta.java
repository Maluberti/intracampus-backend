package com.laurp.intracampus.Domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Atleta {
    @Id
    private Long id; //numero usp

    private String name;

    private String rg;

    private String cpf;

    private Boolean formado;

    @ManyToOne
    private Atletica atletica;



}
