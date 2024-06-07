package com.fss.pharmacie.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PanierElem {
    private Produit produit;
    private int quantite;

    public PanierElem(Produit produit, int quantite){
        this.produit= produit;
        this.quantite=quantite;
    }
}
