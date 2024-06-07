package com.fss.pharmacie.service;

import com.fss.pharmacie.models.Fournisseur;
import com.fss.pharmacie.repository.FournisseurRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FournisseurService {
    private final FournisseurRepository fournisseurRepository;

    public FournisseurService(FournisseurRepository fournisseurRepository) {
        this.fournisseurRepository = fournisseurRepository;
    }

    public List<Fournisseur> getAllFournisseur() {

        return (List<Fournisseur>) fournisseurRepository.findAll();
    }

    public Fournisseur saveFournisseur(Fournisseur fournisseur) {

        return fournisseurRepository.save(fournisseur);
    }

    public void deleteFournisseur(Long id) {

        fournisseurRepository.deleteById(id);
    }
}
