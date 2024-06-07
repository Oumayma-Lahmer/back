package com.fss.pharmacie.controller;

import com.fss.pharmacie.models.Panier;
import com.fss.pharmacie.models.Produit;
import com.fss.pharmacie.service.PanierService;
import com.fss.pharmacie.service.ProduitService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;

@RestController
@RequestMapping("/api/produit")
public class ProduitController {
    @Autowired
    private final ProduitService produitService;

    @Autowired
    private ImageUploadController imageUploadController;
    @Autowired
    private  final PanierService panierService;

    public ProduitController(ProduitService produitService, PanierService panierService) {
        this.produitService = produitService;
        this.panierService = panierService;
    }
    @GetMapping("/list")
    public List<Produit> getAllProduits() {
        return produitService.getAllProduits();
    }
    @PostMapping("/save")
    public Produit saveProduit(@RequestBody Produit produit) {

        return produitService.saveProduit(produit);
    }

    @DeleteMapping("/{id}")
    public void deleteProduit(@PathVariable Long id) {

        produitService.deleteProduit(id);
    }
    @PutMapping("/{id}")
    public Produit updateProduit(@RequestBody Produit produit){
        return produitService.updateProduit(produit);
    }

    @PostMapping("/addToPanier")
    public ResponseEntity<String> ajoutAuPanier(@RequestParam("id") Long id, @RequestParam("quantite") int quantite, HttpSession session) {
        panierService.ajoutProduit(id, quantite, session);
        return ResponseEntity.ok("Produit ajouté au panier avec succès");
    }
    @PostMapping("/remove-from-panier")
    public void effacerProduitPanier(@RequestParam("id") Long id, HttpSession session) {
        panierService.effacerProduit(id, session);
    }
    @PostMapping("/clear-panier")
    public void clearPanier(HttpSession session) {
        panierService.clear(session);
    }
    @PostMapping("/addProduct")
    public ResponseEntity<String> addProduct(@RequestParam("nomCommercial") String nomCommercial,
                                             @RequestParam("prix") Double prix,
                                             @RequestParam("imageFile") MultipartFile imageFile,
                                             @RequestParam("quantite") int quantite)
    {
        try {
            // Get the file's original filename
            String originalFilename = imageFile.getOriginalFilename();

            // Set the target location
            String uploadDir = "./uploads/";
            Path targetLocation = Paths.get(uploadDir).resolve(originalFilename);

            // Create directories if they don't exist
            Files.createDirectories(targetLocation.getParent());

            // Copy the file to the target location
            Files.copy(imageFile.getInputStream(), targetLocation, StandardCopyOption.REPLACE_EXISTING);

            // Create the image URL
            String imageUrl = "/uploads/" + originalFilename;

            // Create product multiple times based on the specified quantity and set image URL
            for (int i = 0; i < quantite; i++){
                Produit produit = new Produit();
                produit.setNomCommercial(nomCommercial);
                produit.setPrix(prix);
                produit.setImageUrl(imageUrl);

                produitService.saveProduit(produit);
            }


            return ResponseEntity.status(HttpStatus.CREATED).body("Product added successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to add product");
        }
    }

    @GetMapping("/products")
    public ResponseEntity<List<Produit>> getAllProducts() {
        return ResponseEntity.ok(produitService.getAllProduits());
    }
    @GetMapping("/panier/count")
    public ResponseEntity<Integer> getPanierCount(HttpSession session) {
        int count = panierService.getPanierCount(session);
        return ResponseEntity.ok(count);
    }
    @GetMapping("/panier")
    public ResponseEntity<Panier> getPanier(HttpSession session) {
        Panier panier = panierService.getPanier(session);
        return ResponseEntity.ok(panier);
    }

}
