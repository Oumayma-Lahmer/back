package com.fss.pharmacie.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor

public class Fournisseur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private long numTel;
    private String nom;
    private String prenom;
    private String email;
    private String adresse;
    private String convention;

    @OneToMany(mappedBy = "fournisseur", cascade = CascadeType.ALL)
    private List<Produit> produits;
}
