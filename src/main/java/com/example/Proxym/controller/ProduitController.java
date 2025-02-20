package com.example.Proxym.controller;


import com.example.Proxym.dto.AddressDTO.AddressRequestDTO;
import com.example.Proxym.dto.AddressDTO.AddressResponseDTO;
import com.example.Proxym.dto.AssureDTO.AssureResponseDTO;
import com.example.Proxym.dto.ProduitDTO.ProduitRequestDTO;
import com.example.Proxym.dto.ProduitDTO.ProduitResponseDTO;
import com.example.Proxym.service.fascade.ProduitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("produit")
public class ProduitController {
    ProduitService produitService ;

    @Autowired
    public ProduitController( ProduitService produitService) {
        this.produitService=produitService;
    }
    @GetMapping("")
    public ResponseEntity<List<ProduitResponseDTO>> getProduit() {
        return new ResponseEntity<>(produitService.findAll() , HttpStatus.OK) ;
    }

    @PostMapping("")
    public ResponseEntity<ProduitResponseDTO> save(@RequestBody ProduitRequestDTO produitRequestDTO) {
        ProduitResponseDTO produitResponseDTO = produitService.save(produitRequestDTO) ;
        return new ResponseEntity<>(produitResponseDTO , HttpStatus.CREATED) ;


    }

}
