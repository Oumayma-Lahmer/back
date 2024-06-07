package com.fss.pharmacie.controller;

import com.fss.pharmacie.models.Payement;
import com.fss.pharmacie.service.PayementService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/payement")
public class PayementController {
    private final PayementService payementService;
    public PayementController(PayementService payementService){
        this.payementService= payementService;
    }
    @GetMapping("/list")
    public List<Payement> getAllPayement (){
        return payementService.getAllPayement();
    }
    @PostMapping("/save")
    public Payement savePayement(@RequestBody Payement payement){
        return payementService.savePayment(payement);
    }

    @DeleteMapping("/{id}")
    public void deletePayement(@PathVariable Long id){
        payementService.deletePayement(id);
    }
}
