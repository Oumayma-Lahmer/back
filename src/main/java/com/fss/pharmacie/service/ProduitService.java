package com.fss.pharmacie.service;

import com.fss.pharmacie.models.Produit;
import com.fss.pharmacie.repository.ProduitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProduitService {
    @Autowired
    private final ProduitRepository produitRepository;


    public ProduitService(ProduitRepository produitRepository) {

        this.produitRepository= produitRepository;
    }

    public List<Produit> getAllProduits() {

        return (List<Produit>) produitRepository.findAll();
    }



    public Produit saveProduit(Produit produit) {
        return produitRepository.save(produit);
    }

    public void deleteProduit(Long id) {
        produitRepository.deleteById(id);
    }
    public Produit updateProduit(Produit produit) {
        return produitRepository.save(produit);
    }

    public Optional<Produit> getProduitById(Long id) {
        return produitRepository.findById(id);
    }



}
