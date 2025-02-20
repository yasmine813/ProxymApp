package com.example.Proxym.Repository;

import com.example.Proxym.Entities.Devis;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DevisDAO extends JpaRepository<Devis,Long> {
}
