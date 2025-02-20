package com.example.Proxym.service.fascade;

import com.example.Proxym.dto.ProduitDTO.ProduitRequestDTO;
import com.example.Proxym.dto.ProduitDTO.ProduitResponseDTO;

import java.util.List;

public interface ProduitService {
    ProduitResponseDTO save(ProduitRequestDTO produitRequestDTO);

    List<ProduitResponseDTO> findAll();


}
