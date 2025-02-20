package com.example.Proxym.service.fascade;

import com.example.Proxym.dto.ContratDTO.ContratRequestDTO;
import com.example.Proxym.dto.ContratDTO.ContratResponseDTO;

import java.util.List;


public interface ContratService {
    ContratResponseDTO save(ContratRequestDTO contratRequestDTO) ;

    ContratResponseDTO findById(Long id ) ;

    void delete(Long id) ;

    ContratResponseDTO update(ContratRequestDTO contratRequestDTO , Long  id ) ;
    List<ContratResponseDTO> findAll() ;

    List<ContratResponseDTO> getContractsByAssureId(Long idAssure) ;



   List<ContratResponseDTO> getContratByProduitId( Long produitId);

    ContratResponseDTO convertDevisToContrat(Long idDevis) ;
}
