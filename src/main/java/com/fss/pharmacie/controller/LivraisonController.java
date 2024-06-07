package com.fss.pharmacie.controller;

import com.fss.pharmacie.models.Livraison;

import com.fss.pharmacie.service.LivraisonService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/livraison")
public class LivraisonController {
    private final LivraisonService livraisonService;
    public LivraisonController (LivraisonService livraisonService){
        this.livraisonService= livraisonService;
    }
    @GetMapping("/list")
    public List<Livraison> getAllLivraison(){
        return livraisonService.getAllLivraison();
    }
    @PostMapping("/save")
     public Livraison saveLivraison(@RequestBody Livraison livraison){
        return livraisonService.saveLivraison(livraison);
     }
     @DeleteMapping("/{id}")
    public void deletelivraison(@PathVariable Long id){
        livraisonService.deletLivraison(id);
     }
}
