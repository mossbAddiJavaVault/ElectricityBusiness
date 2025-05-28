package com.humanbooster.demo.model;

import jakarta.persistence.Embeddable;

@Embeddable
public class UtilisateurBorneId {
    private int utilisateurId;
    private Long borneId;
}
