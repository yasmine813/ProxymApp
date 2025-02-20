package com.example.Proxym.controller;

import com.example.Proxym.Entities.Contrat;
import com.example.Proxym.dto.AssureDTO.AssureRequestDTO;
import com.example.Proxym.dto.AssureDTO.AssureResponseDTO;
import com.example.Proxym.dto.ContratDTO.ContratRequestDTO;
import com.example.Proxym.dto.ContratDTO.ContratResponseDTO;
import com.example.Proxym.service.fascade.ContratService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("contrats")
public class ContratController {
    ContratService contratService ;

    @Autowired
    public ContratController (ContratService contratService) {
        this.contratService = contratService ;
    }
    @GetMapping("")
    public ResponseEntity<List<ContratResponseDTO>>  getContrat() {
        return new ResponseEntity<>(contratService.findAll(), HttpStatus.OK) ;

    }
    @PostMapping("")
    public ResponseEntity<ContratResponseDTO >save(@RequestBody() ContratRequestDTO contratRequestDTO) {
        ContratResponseDTO contratResponseDTO =  contratService.save(contratRequestDTO) ;
        return new ResponseEntity<>(contratResponseDTO, HttpStatus.CREATED) ;
    }
    @GetMapping("/id/{id}")
    public ResponseEntity<ContratResponseDTO> findById(@PathVariable("id") Long id) {
        ContratResponseDTO contratResponseDTO= contratService.findById(id);
        return ResponseEntity.ok(contratResponseDTO);
    }
    @DeleteMapping("/id/{id}")
    public ResponseEntity<?>delete(@PathVariable("id") Long id) {
        contratService.delete(id);
        return ResponseEntity.noContent().build() ;
    }
    @PutMapping("/id/{id}")
    public ResponseEntity<ContratResponseDTO> update(@RequestBody() ContratRequestDTO contratRequestDTO , @PathVariable("id") Long id ) {
        ContratResponseDTO contratResponseDTO =  contratService.update(contratRequestDTO , id );
        return ResponseEntity.accepted().body(contratResponseDTO) ;
    }

    @GetMapping("/assure/{assureId}")
    public ResponseEntity<List<ContratResponseDTO>> getContractsByAssureId(@PathVariable("assureId") Long assureId) {
        List<ContratResponseDTO> contrats = contratService.getContractsByAssureId(assureId);
        return new ResponseEntity<>(contrats, HttpStatus.OK);
    }
    @GetMapping("/produit/{produitId}")
    public ResponseEntity<List<ContratResponseDTO>> getContractsByProduitId(@PathVariable("produitId") Long produitId) {
       List<ContratResponseDTO> contrats = contratService.getContratByProduitId(produitId);
        return new ResponseEntity<>(contrats, HttpStatus.OK);
    }

    @GetMapping("/devis/{devisId}")
    public ResponseEntity<ContratResponseDTO> convertDevisToContrat(@PathVariable("devisId") Long devisId) {
        ContratResponseDTO contratResponseDTO = contratService.convertDevisToContrat(devisId) ;
        return new ResponseEntity<>(contratResponseDTO, HttpStatus.CREATED);
    }
    

}
