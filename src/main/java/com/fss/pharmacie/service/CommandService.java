package com.fss.pharmacie.service;

import com.fss.pharmacie.models.Commande;
import com.fss.pharmacie.models.Produit;
import com.fss.pharmacie.repository.CommandRepository;
import com.fss.pharmacie.repository.ProduitRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CommandService {
    private final CommandRepository commandRepository;
    private final ProduitRepository produitRepository;

    public CommandService(CommandRepository commandRepository, ProduitRepository produitRepository) {
        this.commandRepository = commandRepository;
        this.produitRepository = produitRepository;
    }

    public List<Commande> getAllCommand() {
        return (List<Commande>) commandRepository.findAll();
    }

    public Commande saveCommand(Commande commande) {

        commande.setEtat("Non confirmée");
        for (Produit produit: commande.getProduits()){
            produit.setCommande(commande);
        }
        return commandRepository.save(commande);
    }


    public void deleteCommand(Long id) {
        commandRepository.deleteById(id);
    }

    public Optional<Commande> getCommandeById(Long id){return commandRepository.findById(id);}



}
