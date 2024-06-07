package com.fss.pharmacie.controller;

import com.fss.pharmacie.models.Employe;
import com.fss.pharmacie.service.EmployeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/employe")
public class EmployeController {

     @Autowired
    private final EmployeService employeService;


    public EmployeController(EmployeService employeService) {
        this.employeService=employeService;
    }

    @GetMapping("/list")
    public List<Employe> getAllEmploye() {
        return employeService.getAllEmploye();
    }

    @PostMapping("/save")
    public Employe saveEmploye(@RequestBody Employe employe) {
        return employeService.saveEmploye(employe);
    }

    @DeleteMapping("/{id}")
    public void deleteEmploye(@PathVariable Long id) {
        employeService.deleteEmploye(id);
    }
    @GetMapping("/{id}")
    public Optional<Employe> getEmployeById(@PathVariable Long id) {
        return employeService.getEmployeById(id);
    }

}
