package com.fss.pharmacie.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor

public class Livraison {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private Date date;
    private boolean etat;
    private String recommandation;

    @OneToMany(mappedBy = "livraison", cascade = CascadeType.ALL)
    private List<Commande> commandeList;

}
