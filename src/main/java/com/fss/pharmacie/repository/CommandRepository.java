package com.fss.pharmacie.repository;

import com.fss.pharmacie.models.Commande;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommandRepository extends JpaRepository<Commande,Long> {
}
