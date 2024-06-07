package com.fss.pharmacie.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Getter
@Setter
@AllArgsConstructor
public class Produit {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    private String nomCommercial;
    private String nLot;
    private Date exp;
    private double prix;

    private String dosage;
    private String conditionnement;

     private String imageUrl;

    public Produit() {
    }

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "commande")
    private Commande commande;

    @ManyToOne
    @JoinColumn(name = "stock")
    private Stock stock;

    @ManyToOne
    @JoinColumn(name = "fournisseur")
    private Fournisseur fournisseur;
}

