package com.fss.pharmacie.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor

public class Reclamation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private boolean statut;
    private String description;
    private Date date;

    @ManyToOne
    @JoinColumn(name = "admin")
    private Admin admin;
}
