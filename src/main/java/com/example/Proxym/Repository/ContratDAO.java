package com.example.Proxym.Repository;

import com.example.Proxym.Entities.Contrat;
import com.example.Proxym.dto.ContratDTO.ContratRequestDTO;
import com.example.Proxym.dto.ContratDTO.ContratResponseDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContratDAO extends JpaRepository<Contrat,Long> {
    List<Contrat> findByAssureIdAssure( Long assureId);
    List<Contrat> findByProduit_IdProduit(Long produitId);

    

}
