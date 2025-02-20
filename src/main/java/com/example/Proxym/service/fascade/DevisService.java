package com.example.Proxym.service.fascade;

import com.example.Proxym.dto.DevisDTO.DevisRequestDTO;
import com.example.Proxym.dto.DevisDTO.DevisResponseDTO;

import java.util.List;

public interface DevisService {
    Long save(DevisRequestDTO devisRequestDTO) ;

    DevisResponseDTO findById(Long id ) ;

    void delete(Long id) ;

    DevisResponseDTO update(DevisRequestDTO devisRequestDTO , Long  id ) ;
    List<DevisResponseDTO> findAll() ;

    double calculDevis(long produitId , Integer duree,long assureId) ;
}
