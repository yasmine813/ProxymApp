package com.example.Proxym.controller;

import com.example.Proxym.Entities.Contrat;
import com.example.Proxym.dto.AssureDTO.AssureRequestDTO;
import com.example.Proxym.dto.AssureDTO.AssureResponseDTO;
import com.example.Proxym.exception.EntityNotFoundException;
import com.example.Proxym.service.fascade.AssureService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("assure")
public class AssureController {
    AssureService assureService ;

    @Autowired
    public AssureController(AssureService assureService) {
        this.assureService=assureService ;
    }

    @GetMapping("")
    public ResponseEntity<List<AssureResponseDTO>>  getAssure() {
        return new ResponseEntity<>(assureService.findAll(), HttpStatus.OK) ;

    }
    @PostMapping("")
    public ResponseEntity<AssureResponseDTO >save(@Valid @RequestBody() AssureRequestDTO assureRequestDTO) {
        AssureResponseDTO assureResponseDTO =  assureService.save(assureRequestDTO) ;
        return new ResponseEntity<>(assureResponseDTO, HttpStatus.CREATED) ;
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<AssureResponseDTO> findById(@PathVariable("id") Long id) {
        AssureResponseDTO assureResponseDTO= assureService.findById(id);
        return ResponseEntity.ok(assureResponseDTO);
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<AssureResponseDTO> findByName(@PathVariable("name") String name) {
        AssureResponseDTO assureResponseDTO = assureService.findByName(name);
        return ResponseEntity.ok( assureResponseDTO) ;
    }
    @DeleteMapping("/id/{id}")
    public ResponseEntity<?>delete(@PathVariable("id") Long id) {
        assureService.delete(id);
        return ResponseEntity.noContent().build() ;
    }
    @PutMapping("/id/{id}")
    public ResponseEntity<AssureResponseDTO> update(@Valid @RequestBody() AssureRequestDTO assureRequestDTO , @PathVariable("id") Long id ) throws ChangeSetPersister.NotFoundException {
        AssureResponseDTO assureResponseDTO =  assureService.update(assureRequestDTO , id );
        return ResponseEntity.accepted().body(assureResponseDTO) ;
    }

    @GetMapping("/address/{idAddress}")
    public ResponseEntity<AssureResponseDTO> getAssureByIdAddress(@PathVariable("idAddress") Long id) {
        AssureResponseDTO assureResponseDTO = assureService.findByIdAddress(id) ;
        return ResponseEntity.ok(assureResponseDTO) ;

    }




}
