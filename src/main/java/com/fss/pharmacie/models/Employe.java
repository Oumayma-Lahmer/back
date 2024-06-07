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


public class Employe extends User {

    private int experience;
    private double salaire;



    public Employe(  String nom, String prenom,String email, String password, String adresse, String telephone, int experience){
        super(nom, prenom,email,password,adresse,telephone);
        this.experience=experience;
    }

    @ManyToMany
    @JoinTable(name = "EmployeStock",
            joinColumns = {
            @JoinColumn(name="employe") },
            inverseJoinColumns = {
            @JoinColumn(name = "stock")})
    private List<Stock> stockList;

}
