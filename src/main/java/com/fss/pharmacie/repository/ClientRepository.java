package com.fss.pharmacie.repository;

import com.fss.pharmacie.models.Client;
import com.fss.pharmacie.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {
    Client findByEmail(String email);

}
