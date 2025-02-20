package com.example.Proxym.service.impl;

import com.example.Proxym.Entities.Assure;
import com.example.Proxym.Entities.Produit;
import com.example.Proxym.Repository.ProduitDAO;
import com.example.Proxym.dto.AddressDTO.AddressResponseDTO;
import com.example.Proxym.dto.AssureDTO.AssureResponseDTO;
import com.example.Proxym.dto.ProduitDTO.ProduitRequestDTO;
import com.example.Proxym.dto.ProduitDTO.ProduitResponseDTO;
import com.example.Proxym.exception.EntityNotFoundException;
import com.example.Proxym.service.fascade.ProduitService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProduitServiceImpl implements ProduitService {

    ProduitDAO produitDAO;
    ModelMapper modelMapper;

    @Autowired
    public ProduitServiceImpl(ProduitDAO produitDAO , ModelMapper modelMapper) {
        this.produitDAO=produitDAO;
        this.modelMapper=modelMapper;
    }

    @Override
    public ProduitResponseDTO save(ProduitRequestDTO produitRequestDTO) {
        Produit produitEntity=modelMapper.map(produitRequestDTO,Produit.class);
        Produit saved =produitDAO.save(produitEntity);

        return modelMapper.map(saved,ProduitResponseDTO.class);
    }

    @Override
    public List<ProduitResponseDTO> findAll() {
        return produitDAO.findAll()
                .stream()
                .map(e -> modelMapper.map(e, ProduitResponseDTO.class))
                .collect(Collectors.toList());
    }



}
