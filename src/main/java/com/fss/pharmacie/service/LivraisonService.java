package com.fss.pharmacie.service;

import com.fss.pharmacie.models.Livraison;
import com.fss.pharmacie.repository.LivraisonRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LivraisonService {
    private final LivraisonRepository livraisonRepository;
    public LivraisonService(LivraisonRepository livraisonRepository){
        this.livraisonRepository= livraisonRepository;
    }
    public List<Livraison> getAllLivraison(){
        return (List<Livraison>) livraisonRepository.findAll();
    }
    public Livraison saveLivraison(Livraison livraison){
        return livraisonRepository.save(livraison);
    }
    public void deletLivraison(Long id){
        livraisonRepository.deleteById(id);
    }
}
