package com.fss.pharmacie.service;

import com.fss.pharmacie.models.Livraison;
import com.fss.pharmacie.models.Payement;
import com.fss.pharmacie.repository.PayementRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PayementService {
    private final PayementRepository payementRepository;
    public PayementService(PayementRepository payementRepository){
        this.payementRepository = payementRepository;
    }
    public List<Payement> getAllPayement(){
        return (List<Payement>)payementRepository.findAll();
    }
    public Payement savePayment(Payement payement){
        return payementRepository.save(payement);
    }
    public void deletePayement(Long id){
        payementRepository.deleteById(id);
    }
}
