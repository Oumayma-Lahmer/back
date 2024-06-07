package com.fss.pharmacie.controller;


import com.fss.pharmacie.models.Reclamation;
import com.fss.pharmacie.service.ReclamationService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reclamation")
public class ReclamationController {
    private final ReclamationService reclamationService;
    public ReclamationController(ReclamationService reclamationService){
        this.reclamationService= reclamationService;
    }
    @GetMapping("/list")
    public List<Reclamation> getAllReclamation() {
        return reclamationService.getAllReclamation();
    }
    @PostMapping("/save")
    public Reclamation saveReclamation(@RequestBody Reclamation reclamation) {
        return reclamationService.saveReclamation(reclamation);
    }

    @DeleteMapping("/{id}")
    public void deleteReclamation(@PathVariable Long id) {
        reclamationService.deleteReclamation(id);
    }


}
