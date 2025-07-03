package org.example.enaaskills.controller;

import org.example.enaaskills.dto.CompetenceDto;
import org.example.enaaskills.service.CompetenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/competences")
public class CompetenceController {
    private final CompetenceService competenceService;

    @Autowired
    public CompetenceController(CompetenceService competenceService) {
        this.competenceService = competenceService;
    }

    @GetMapping("/{id}")
    public CompetenceDto getCompetenceById(@PathVariable Long id) {
        return competenceService.getCompetenceById(id);
    }

    @PostMapping
    public CompetenceDto creerCompetence(@RequestBody CompetenceDto dto) {
        return competenceService.creerCompetence(dto);
    }
} 