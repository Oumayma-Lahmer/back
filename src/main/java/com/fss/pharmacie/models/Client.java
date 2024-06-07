package com.fss.pharmacie.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;


@Entity
@Getter
@Setter
@NoArgsConstructor

public class Client extends User{
    private int fidelite;

    @JsonManagedReference

    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL)
    private List<Commande> commandeList;


   public Client(  String nom, String prenom,String email, String password, String adresse, String telephone, int fidelite){
       super(nom, prenom,email,password,adresse,telephone);
       this.fidelite=fidelite;
   }

}
