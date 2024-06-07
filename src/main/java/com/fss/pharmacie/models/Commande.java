package com.fss.pharmacie.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Commande {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String description;
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;
    private String etat;
     private  double totalAmount;
     private String ordonnanceFilePath;


    @ManyToOne
    @JoinColumn(name = "payement")
    private Payement payement;

    @ManyToOne
    @JoinColumn(name = "livraison")
    private Livraison livraison;


    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "client")
    private Client client;

    @JsonManagedReference
    @OneToMany(mappedBy = "commande", cascade = CascadeType.ALL)
    private List<Produit> produits;

    public Commande(Date date, String ordonnanceFilePath, Client client) {
        this.date = date;

        this.ordonnanceFilePath = ordonnanceFilePath;
        this.client = client;
    }




}
