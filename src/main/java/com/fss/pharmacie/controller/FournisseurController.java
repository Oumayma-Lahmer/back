package com.fss.pharmacie.controller;

import com.fss.pharmacie.models.Fournisseur;
import com.fss.pharmacie.service.FournisseurService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/fournisseur")
public class FournisseurController {

    private final FournisseurService fournisseurService;

    public FournisseurController (FournisseurService fournisseurService){
        this.fournisseurService= fournisseurService;
    }

    @GetMapping("/list")
    public List<Fournisseur> getAllFournisseur(){
        return fournisseurService.getAllFournisseur();
    }
    @PostMapping("/save")
    public Fournisseur SaveFournisseur(@RequestBody Fournisseur fournisseur){
        return fournisseurService.saveFournisseur(fournisseur);
    }

    @DeleteMapping("/{id}")
    public void deleteFournisseur(@PathVariable Long id){
        fournisseurService.deleteFournisseur(id);
    }

}
