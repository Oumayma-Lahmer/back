package com.fss.pharmacie.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor

public class Payement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private String modePayement;
    private Date date;
    private String  reduction ;
    private String montant;
    private boolean etat;

    @OneToMany(mappedBy = "payement", cascade = CascadeType.ALL)
    private List<Commande> commandeList;



}
