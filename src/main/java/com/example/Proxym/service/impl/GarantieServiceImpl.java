package com.example.Proxym.service.impl;

import com.example.Proxym.Entities.Garantie;
import com.example.Proxym.Entities.Produit;
import com.example.Proxym.Repository.GarantieDAO;
import com.example.Proxym.Repository.ProduitDAO;
import com.example.Proxym.dto.GarantieDTO.GarantieResponseDTO;
import com.example.Proxym.dto.GarantieDTO.GarantieResquestDTO;
import com.example.Proxym.dto.ProduitDTO.ProduitResponseDTO;
import com.example.Proxym.exception.EntityNotFoundException;
import com.example.Proxym.service.fascade.GarantieService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service

public class GarantieServiceImpl implements GarantieService {
    ModelMapper modelMapper ;
    GarantieDAO garantieDAO ;
    ProduitDAO produitDAO ;
    @Autowired
    public GarantieServiceImpl(ModelMapper modelMapper, GarantieDAO garantieDAO ,ProduitDAO produitDAO) {
        this.modelMapper = modelMapper;
        this.garantieDAO = garantieDAO;
        this.produitDAO=produitDAO ;
    }




    @Override
    public GarantieResponseDTO save(GarantieResquestDTO garantieRequestDTO) {
        Long produitId = garantieRequestDTO.getProduitId();
        Produit produitEntity = produitDAO.findById(produitId)
                .orElseThrow(() -> new EntityNotFoundException("Produit not found"));

        Garantie garantieEntity = modelMapper.map(garantieRequestDTO, Garantie.class);
        garantieEntity.setProduit(produitEntity);

        Garantie savedGarantie = garantieDAO.save(garantieEntity);

        GarantieResponseDTO garantieResponseDTO = modelMapper.map(savedGarantie, GarantieResponseDTO.class);
        garantieResponseDTO.setProduitId(produitId);

        return garantieResponseDTO;
    }


    @Override
    public List<GarantieResponseDTO> findAll() {
        return garantieDAO.findAll()
                .stream()
                .map(e -> {
                    GarantieResponseDTO garantieResponseDto = modelMapper.map(e, GarantieResponseDTO.class);
                    garantieResponseDto.setProduitId(e.getProduit().getIdProduit());
                    return garantieResponseDto;
                })
                .collect(Collectors.toList());
    }

    @Override
    public List<GarantieResponseDTO> findByProduitId(Long produitId) {
        List<Garantie> garanties = garantieDAO.findByProduit_IdProduit(produitId) ;
        return  garanties.stream()
                .map(e -> {
                  GarantieResponseDTO garantieResponseDTO =   modelMapper.map(e, GarantieResponseDTO.class) ;
                  garantieResponseDTO.setProduitId(e.getProduit().getIdProduit());
                  return garantieResponseDTO ;
                } )
                .collect(Collectors.toList());
    }
}
