package com.humanbooster.demo.model;

import java.time.LocalDate;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class UtilisateurBorne {
    @EmbeddedId
    private UtilisateurBorneId id = new UtilisateurBorneId();

    @ManyToOne
    @JoinColumn(name = "utilisateur_id", referencedColumnName = "id", insertable = false, updatable = false)
    private Utilisateur utilisateur;


    @ManyToOne
    @JoinColumn(name = "borne_id", referencedColumnName = "id", insertable = false, updatable = false)
    private Borne borne;

    private int numReservation;

    private LocalDate dateReservation;
    


}
