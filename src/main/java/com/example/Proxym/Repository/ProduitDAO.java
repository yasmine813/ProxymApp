package com.example.Proxym.Repository;

import com.example.Proxym.Entities.Produit;
import com.example.Proxym.dto.ProduitDTO.ProduitResponseDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProduitDAO extends JpaRepository<Produit,Long> {
    Produit findByIdProduit(Long produitId) ;

}
