package com.fss.pharmacie.repository;

import com.fss.pharmacie.models.Client;
import com.fss.pharmacie.models.Employe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EmployeRepository extends JpaRepository<Employe, Long> {
    Employe findByEmail(String email);

}
