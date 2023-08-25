package com.laurp.intracampus.mapper;

import com.laurp.intracampus.Domain.Atleta;
import com.laurp.intracampus.model.AtletaCreateDTO;
import com.laurp.intracampus.model.AtletaDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring",  uses = {AtleticaMapper.class})
public interface AtletaMapper {
    AtletaMapper INSTANCE = Mappers.getMapper(AtletaMapper.class);

    @Mapping(target = "atleticaName", source = "atletica.name")
    AtletaDTO toDTO (Atleta atleta);
    @Mapping(target = "atletica.id", source = "atleticaId")
    Atleta toEntity(AtletaCreateDTO atletaCreateDTO);
}
