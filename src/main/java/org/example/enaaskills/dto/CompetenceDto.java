package org.example.enaaskills.dto;

import java.util.List;

public class CompetenceDto {
    private String nom;
    private String description;
    private List<SousCompetenceDto> sousCompetences;

    // Getters et setters
    public String getNom() { return nom; }
    public void setNom(String nom) { this.nom = nom; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    public List<SousCompetenceDto> getSousCompetences() { return sousCompetences; }
    public void setSousCompetences(List<SousCompetenceDto> sousCompetences) { this.sousCompetences = sousCompetences; }

    public static class SousCompetenceDto {
        private String nom;
        private boolean validee;

        // Getters et setters
        public String getNom() { return nom; }
        public void setNom(String nom) { this.nom = nom; }
        public boolean isValidee() { return validee; }
        public void setValidee(boolean validee) { this.validee = validee; }
    }
} 