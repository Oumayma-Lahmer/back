package com.fss.pharmacie.repository;

import com.fss.pharmacie.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository  <User, Long> {





}
