package com.example.Proxym.controller;

import com.example.Proxym.dto.AddressDTO.AddressRequestDTO;
import com.example.Proxym.dto.AddressDTO.AddressResponseDTO;
import com.example.Proxym.service.fascade.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("address")
public class AddressController {
    AddressService addressService ;

    @Autowired
    public AddressController(AddressService addressService) {
        this.addressService = addressService;
    }

    @PostMapping("")
    public ResponseEntity<AddressResponseDTO> save(@RequestBody AddressRequestDTO addressRequestDTO) {
        AddressResponseDTO addressResponseDTO = addressService.save(addressRequestDTO) ;
        return new ResponseEntity<>(addressResponseDTO , HttpStatus.CREATED) ;


    }
    @GetMapping
    public ResponseEntity<List<AddressResponseDTO>> getAddress() {
        return new ResponseEntity<>(addressService.findAll() , HttpStatus.OK) ;
    }
    @PutMapping("/id/{id}")
    public  ResponseEntity<AddressResponseDTO> update(@RequestBody AddressRequestDTO addressRequestDTO ,@PathVariable("id") Long id) {
        AddressResponseDTO addressResponseDTO = addressService.update(addressRequestDTO , id) ;
        return ResponseEntity.accepted().body(addressResponseDTO) ;
    }

}
