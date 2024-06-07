package com.fss.pharmacie.service;

import com.fss.pharmacie.models.Reclamation;
import com.fss.pharmacie.repository.ReclamationRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReclamationService {
    public final ReclamationRepository reclamationRepository;
    public ReclamationService (ReclamationRepository reclamationRepository){
        this.reclamationRepository= reclamationRepository;
    }
    public List<Reclamation> getAllReclamation(){
        return reclamationRepository.findAll();
    }
    public Reclamation saveReclamation(Reclamation reclamation){
        return reclamationRepository.save(reclamation);
    }
    public void deleteReclamation(Long id){
        reclamationRepository.deleteById(id);
    }
}
