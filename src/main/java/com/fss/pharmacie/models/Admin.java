package com.fss.pharmacie.models;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor

public class Admin extends User{

    private int experience;


    @OneToMany(mappedBy = "admin", cascade = CascadeType.ALL)
    private List<Reclamation> reclamations;


    public Admin(  String nom, String prenom,String email, String password, String adresse, String telephone, int experience){
        super(nom, prenom,email,password,adresse,telephone);
        this.experience=experience;
    }
}
