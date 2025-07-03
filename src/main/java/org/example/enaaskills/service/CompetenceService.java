package org.example.enaaskills.service;

import org.example.enaaskills.dto.CompetenceDto;
import org.example.enaaskills.mapper.CompetenceMapper;
import org.example.enaaskills.model.Competence;
import org.example.enaaskills.model.SousCompetence;
import org.example.enaaskills.repository.CompetenceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompetenceService {
    private final CompetenceRepository competenceRepository;
    private final CompetenceMapper competenceMapper;

    @Autowired
    public CompetenceService(CompetenceRepository competenceRepository, CompetenceMapper competenceMapper) {
        this.competenceRepository = competenceRepository;
        this.competenceMapper = competenceMapper;
    }

    public CompetenceDto creerCompetence(CompetenceDto dto) {
        Competence competence = competenceMapper.toEntity(dto);
        if (dto.getSousCompetences() != null) {
            List<SousCompetence> sousCompetences = new java.util.ArrayList<>();
            for (CompetenceDto.SousCompetenceDto scDto : dto.getSousCompetences()) {
                SousCompetence sc = competenceMapper.toEntity(scDto);
                sc.setCompetence(competence);
                sousCompetences.add(sc);
            }
            competence.setSousCompetences(sousCompetences);
        }
        Competence saved = competenceRepository.save(competence);
        return competenceMapper.toDto(saved);
    }
    //Cette partie du code prend chaque sous-compétence reçue dans la requête,
    // la convertit en entité, la relie à la compétence principale,
    // puis construit la liste complète des sous-compétences à associer à la compétence
    // avant de sauvegarder le tout.

    public CompetenceDto getCompetenceById(Long id) {
        Competence competence = competenceRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Compétence non trouvée"));
        return competenceMapper.toDto(competence);
    }
}