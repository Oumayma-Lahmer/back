package com.fss.pharmacie.repository;

import com.fss.pharmacie.models.Payement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PayementRepository extends JpaRepository<Payement,Long> {
}
