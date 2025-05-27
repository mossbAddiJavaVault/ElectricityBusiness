package com.humanbooster.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.humanbooster.demo.model.Utilisateur;
import com.humanbooster.demo.repository.UtilisateurRepository;

import jakarta.transaction.Transactional;


@Service
public class UtilisateurService {
    private final UtilisateurRepository utilisateurRepository;

    @Autowired
    public UtilisateurService(UtilisateurRepository utilisateurRepository) {
        this.utilisateurRepository = utilisateurRepository;
    }

    @Transactional
    public void saveUtilisateur(com.humanbooster.demo.model.Utilisateur utilisateur) {
        utilisateurRepository.save(utilisateur);
    }

    public List<Utilisateur> getAllUtilisateurs() {
        return utilisateurRepository.findAll();
    }

    public Optional<Utilisateur> getUtilisateurById(int id) {
        return utilisateurRepository.findById(id);
    }

    @Transactional
    public Optional<Utilisateur> deleteUtilisateurById(int id) {
        Optional<Utilisateur> utilisateurOpt = utilisateurRepository.findById(id);
        utilisateurOpt.ifPresent(utilisateurRepository::delete);
        return utilisateurOpt;
    }


    // public Optional<Utilisateur> updateUtilisateur(Utilisateur newUtilisateur, int id) {
    //     Optional<Utilisateur> existingUtilisateur = utilisateurRepository.findById(id);
    //     if (existingUtilisateur.isPresent()) {
    //         Utilisateur utilisateur = existingUtilisateur.get();
    //         utilisateur.setNom(newUtilisateur.getNom());
    //         utilisateur.setEmail(newUtilisateur.getEmail());
    //         utilisateur.setMotDePasse(newUtilisateur.getMotDePasse());
    //         return Optional.of(utilisateurRepository.save(utilisateur));
    //     }
    //     // If the utilisateur with the given id does not exist, return an empty Optional
    //     else {
    //         return Optional.empty();
    //     }
    // }

    @Transactional
    public Optional<Utilisateur> updateUtilisateur(Utilisateur newUtilisateur, int id) {
        return utilisateurRepository.findById(id)
                .map(existingUtilisateur -> {
                    existingUtilisateur.setNom(newUtilisateur.getNom());
                    existingUtilisateur.setEmail(newUtilisateur.getEmail());
                    existingUtilisateur.setMotDePasse(newUtilisateur.getMotDePasse());
                    return utilisateurRepository.save(existingUtilisateur);
                });
    }

    




    
}
