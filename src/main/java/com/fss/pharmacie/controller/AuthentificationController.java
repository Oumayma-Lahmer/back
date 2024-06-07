package com.fss.pharmacie.controller;

import com.fss.pharmacie.models.Connexion;
import com.fss.pharmacie.models.InscriptionDTO;
import com.fss.pharmacie.service.InscriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@CrossOrigin(origins = {"http://localhost:4200", "http://localhost:53928"})
@RequestMapping("/api/auth")
public class AuthentificationController {


    @Autowired
private final InscriptionService inscriptionService;

    public AuthentificationController(InscriptionService inscriptionService) {
        this.inscriptionService = inscriptionService;
    }


    @PostMapping("/registre")
    public ResponseEntity<String> inscrireUtilisateur(@RequestBody InscriptionDTO inscriptionDTO) {
        inscriptionService.inscrireUtilisateur(inscriptionDTO);
        return ResponseEntity.ok("Inscription réussie.");
    }

    @PostMapping("/login")
    public ResponseEntity<Map<String, String>> connecterUtilisateur(@RequestBody Connexion connexion) {
        // Ajouter la logique de connexion
        Connexion connexionAvecRole = inscriptionService.connecterUtilisateur(connexion);
        if (connexionAvecRole.getRole() != null) {
            Map<String, String> response = new HashMap<>();
            response.put("success", "true");
            response.put("role", connexionAvecRole.getRole());
            return ResponseEntity.ok(response);
        } else {
            Map<String, String> response = new HashMap<>();
            response.put("success", "false");
            return ResponseEntity.badRequest().body(response);
        }

    }





}
