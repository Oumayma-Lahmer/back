package com.fss.pharmacie.service;

import com.fss.pharmacie.models.Employe;
import com.fss.pharmacie.repository.EmployeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeService {

     private final EmployeRepository employeRepository;
   public EmployeService(EmployeRepository employeRepository){
        this.employeRepository=employeRepository;
    }
    public List<Employe> getAllEmploye() {
        return (List<Employe>) employeRepository.findAll();
    }

    public Employe saveEmploye(Employe employe) {
        return employeRepository.save(employe);
    }

    public void deleteEmploye(Long id) {
        employeRepository.deleteById(id);
    }
    public Optional<Employe> getEmployeById(Long id){return employeRepository.findById(id);}
}
