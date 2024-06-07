package com.fss.pharmacie.service;

import com.fss.pharmacie.models.Panier;
import com.fss.pharmacie.models.PanierElem;
import com.fss.pharmacie.models.Produit;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class PanierService {

    private final ProduitService produitService;
    private static final String SESSION_PANIER = "Panier";

    @Autowired
    public PanierService(ProduitService produitService) {
        this.produitService = produitService;
    }

    public Panier getPanier(HttpSession session) {
        Panier panier = (Panier) session.getAttribute(SESSION_PANIER);
        if (panier == null) {
            panier = new Panier();
            session.setAttribute(SESSION_PANIER, panier);
        }
        return panier;
    }

    public void ajoutProduit(Long id, int quantite, HttpSession session) {
        /*Panier panier = getPanier(session);
        Optional<PanierElem> existingElem = panier.getElemList().stream()
                .filter(panierElem -> panierElem.getProduit().getId().equals(ids))
                .findFirst();
        if (existingElem.isPresent()) {
            existingElem.get().setQuantite(existingElem.get().getQuantite() + quantite);
        } else {
            Produit produit = produitService.getProduitById(id)
                    .orElseThrow(() -> new RuntimeException("Produit not found"));
            panier.ajoutProduit(new PanierElem(produit, quantite));
        }*/
        Panier panier = getPanier(session);


            Optional<Produit> produitOpt = produitService.getProduitById(id);
            if (produitOpt.isPresent()) {
                Produit produit = produitOpt.get();
                Optional<PanierElem> existingElem = panier.getElemList().stream()
                        .filter(panierElem -> panierElem.getProduit().getId().equals(id))
                        .findFirst();

                if (existingElem.isPresent()) {
                    // Increment the quantity of the existing product in the cart
                    existingElem.get().setQuantite(existingElem.get().getQuantite() + quantite);
                } else {
                    // Add a new product to the cart
                    panier.ajoutProduit(new PanierElem(produit, quantite));
                }
            } else {
                throw new RuntimeException("Produit not found with id: " + id);
            }


    }

    public void effacerProduit(Long id, HttpSession session) {
        Panier panier = getPanier(session);
        panier.getElemList().removeIf(panierElem -> panierElem.getProduit().getId().equals(id));
    }

    public void clear(HttpSession session) {
        Panier panier = getPanier(session);
        panier.clear();
    }
    public int getPanierCount(HttpSession session) {
        Panier panier = getPanier(session);
        return panier.getElemList().size();
    }

}
