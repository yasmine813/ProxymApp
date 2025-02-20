package com.example.Proxym.controller;

import com.example.Proxym.Entities.Garantie;
import com.example.Proxym.dto.ContratDTO.ContratResponseDTO;
import com.example.Proxym.dto.GarantieDTO.GarantieResponseDTO;
import com.example.Proxym.dto.GarantieDTO.GarantieResquestDTO;
import com.example.Proxym.dto.ProduitDTO.ProduitRequestDTO;
import com.example.Proxym.dto.ProduitDTO.ProduitResponseDTO;
import com.example.Proxym.service.fascade.GarantieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("garantie")
public class GarantieController {
    GarantieService garantieService ;
    @Autowired
    public GarantieController(GarantieService garantieService) {
        this.garantieService = garantieService;
    }

    @GetMapping("")
    public ResponseEntity<List<GarantieResponseDTO>> getGarantie() {
        return new ResponseEntity<>(garantieService.findAll() , HttpStatus.OK) ;
    }
    @PostMapping("")
    public ResponseEntity<GarantieResponseDTO> save(@RequestBody GarantieResquestDTO garantieResquestDTO) {
        GarantieResponseDTO garantieResponseDTO = garantieService.save(garantieResquestDTO) ;
        return new ResponseEntity<>(garantieResponseDTO , HttpStatus.CREATED) ;


    }
    @GetMapping("/produit/{produitId}")
    public ResponseEntity<List<GarantieResponseDTO>> getGarnatiesByProduitId(@PathVariable("produitId") Long produitId) {
        List<GarantieResponseDTO> garantie = garantieService.findByProduitId(produitId);
        return new ResponseEntity<>(garantie, HttpStatus.OK);
    }
}
