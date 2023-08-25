package com.laurp.intracampus.mapper;

import com.laurp.intracampus.Domain.Atletica;
import com.laurp.intracampus.model.AtleticaCreateDTO;
import com.laurp.intracampus.model.AtleticaDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Component;


@Mapper(componentModel = "spring")
public interface AtleticaMapper {
    AtleticaMapper INSTANCE = Mappers.getMapper(AtleticaMapper.class);

    AtleticaDTO toDTO (Atletica atletica);
    Atletica toEntity(AtleticaCreateDTO atleticaCreateDTO);
}
