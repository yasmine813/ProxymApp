package com.example.Proxym.Repository;

import com.example.Proxym.Entities.Garantie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GarantieDAO extends JpaRepository<Garantie , Long> {
    List<Garantie> findByProduit_IdProduit(Long produitId) ;
}
