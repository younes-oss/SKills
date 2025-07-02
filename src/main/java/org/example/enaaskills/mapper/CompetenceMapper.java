package org.example.enaaskills.mapper;

import org.example.enaaskills.dto.CompetenceDto;
import org.example.enaaskills.model.Competence;
import org.example.enaaskills.model.SousCompetence;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface CompetenceMapper {
    CompetenceMapper INSTANCE = Mappers.getMapper(CompetenceMapper.class);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "sousCompetences", source = "sousCompetences")
    Competence toEntity(CompetenceDto dto);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "competence", ignore = true)
    SousCompetence toEntity(CompetenceDto.SousCompetenceDto dto);

    CompetenceDto toDto(Competence entity);
    CompetenceDto.SousCompetenceDto toDto(SousCompetence entity);
} 