package com.example.Proxym.controller;

import com.example.Proxym.dto.ContratDTO.ContratRequestDTO;
import com.example.Proxym.dto.ContratDTO.ContratResponseDTO;
import com.example.Proxym.dto.DevisDTO.DevisRequestDTO;
import com.example.Proxym.dto.DevisDTO.DevisResponseDTO;
import com.example.Proxym.service.fascade.DevisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("devis")
public class DevisController {
    DevisService devisService ;
    @Autowired
    public DevisController(DevisService devisService) {
        this.devisService = devisService;
    }
    @GetMapping("")
    public ResponseEntity<List<DevisResponseDTO>> getDevis() {
        return new ResponseEntity<>(devisService.findAll(), HttpStatus.OK) ;

    }
    @PostMapping("")
    public ResponseEntity<Long >save(@RequestBody() DevisRequestDTO devisRequestDTO) {
        Long numDevis =  devisService.save(devisRequestDTO) ;
        return new ResponseEntity<>(numDevis, HttpStatus.CREATED) ;
    }
    @GetMapping("/id/{id}")
    public ResponseEntity<DevisResponseDTO> findById(@PathVariable("id") Long id) {
        DevisResponseDTO devisResponseDTO= devisService.findById(id);
        return ResponseEntity.ok(devisResponseDTO);
    }
    @DeleteMapping("/id/{id}")
    public ResponseEntity<?>delete(@PathVariable("id") Long id) {
        devisService.delete(id);
        return ResponseEntity.noContent().build() ;
    }
    @PutMapping("/id/{id}")
    public ResponseEntity<DevisResponseDTO> update(@RequestBody() DevisRequestDTO devisRequestDTO , @PathVariable("id") Long id ) {
        DevisResponseDTO devisResponseDTO =  devisService.update(devisRequestDTO, id );
        return ResponseEntity.accepted().body(devisResponseDTO) ;
    }
    @GetMapping("calculDevis/{idProduit}/{duree}/{idAssure}")
    public  ResponseEntity<Double> calculDevis(@PathVariable("idProduit") Long idProduit, @PathVariable("duree") Integer duree, @PathVariable("idAssure") Long idAssure  ){
        double montantTotale =devisService.calculDevis(idProduit,duree,idAssure) ;
        return  ResponseEntity.ok(montantTotale) ;
    }
}
