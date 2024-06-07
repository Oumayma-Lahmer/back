package com.fss.pharmacie.controller;

import com.fss.pharmacie.models.Client;
import com.fss.pharmacie.models.Commande;
import com.fss.pharmacie.models.Produit;
import com.fss.pharmacie.repository.ProduitRepository;
import com.fss.pharmacie.service.ClientService;
import com.fss.pharmacie.service.CommandService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.*;


@RestController
@RequestMapping("/api/commande")
public class CommandController {

    private final CommandService commandService;
    private final ClientService clientService;
     private final ProduitRepository produitRepository;


    public CommandController(CommandService commandService, ClientService clientService, ProduitRepository produitRepository) {
        this.commandService = commandService;
        this.clientService = clientService;

        this.produitRepository = produitRepository;
    }
    @GetMapping("/List")
    public List<Commande> getAllCommand(){return commandService.getAllCommand();}

    @PostMapping("/save")
    public Commande saveCommande(@RequestBody Commande commande){
        return commandService.saveCommand(commande);
    }

    @DeleteMapping("/{id}")
    public void deleteCommande(@PathVariable Long id){
        commandService.deleteCommand(id);
    }

    @GetMapping("/{id}")
    public Optional<Commande> getCommandeById(@PathVariable Long id) {

        return commandService.getCommandeById(id);
    }

   @PostMapping("/uploadOrdonnance")
    public ResponseEntity <String> uploadOrdonnance(@RequestParam("file") MultipartFile file,
                                                    @RequestParam("clientId") Long clientId,
                                                    @RequestParam("produitId" )List<Long> produitIds){

       String uploadDir = "./uploads/";
        try{
            if (!file.isEmpty()){
                String originalFilename = file.getOriginalFilename();

                Path path = Paths.get(uploadDir).resolve(originalFilename);

                Files.createDirectories(path.getParent());

                Files.copy(file.getInputStream(), path, StandardCopyOption.REPLACE_EXISTING);

                //récuperer l'id de client
                Client client = clientService.getClientById(clientId).orElseThrow(() -> new RuntimeException("Client not found"));
                List<Produit> produits = produitRepository.findAllById(produitIds);
                //String fileUrl = "/uploads/" + originalFilename;
                //retourner le chemin du fichier pour créer la commande
                // response.put("filePath", path.toString());
                Commande commande = new Commande();
                commande.setOrdonnanceFilePath(path.toString());
                commande.setClient(client);
                commande.setProduits(produits);
                for (Produit produit : produits) {
                    produit.setCommande(commande);
                }
                commandService.saveCommand(commande);

                return ResponseEntity.status(HttpStatus.CREATED).body("commande saved succesfully with ordonnance file.");
                /*//Create and save the commande with the file path
                Commande commande = new Commande(new Date(), path.toString() ,client);
                commandService.saveCommand(commande);

                return ResponseEntity.status(HttpStatus.CREATED).body("File uploaded succefully");
                 */
            } else {

                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("File is empty.");                //return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("File is empty");
            }

        }
        catch (IOException e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to upload file");
        }
   }

}

