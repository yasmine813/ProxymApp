package com.example.Proxym.service.fascade;

import com.example.Proxym.dto.GarantieDTO.GarantieResponseDTO;
import com.example.Proxym.dto.GarantieDTO.GarantieResquestDTO;

import java.util.List;

public interface GarantieService {
    GarantieResponseDTO save(GarantieResquestDTO garantieResquestDTO) ;
    List<GarantieResponseDTO> findAll() ;
    List<GarantieResponseDTO> findByProduitId(Long produitId) ;

}
