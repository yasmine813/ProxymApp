package com.example.Proxym.service.impl;

import com.example.Proxym.Entities.*;
import com.example.Proxym.Repository.AssureDAO;
import com.example.Proxym.Repository.DevisDAO;
import com.example.Proxym.Repository.ProduitDAO;
import com.example.Proxym.dto.ContratDTO.ContratResponseDTO;
import com.example.Proxym.dto.DevisDTO.DevisRequestDTO;
import com.example.Proxym.dto.DevisDTO.DevisResponseDTO;
import com.example.Proxym.exception.EntityNotFoundException;
import com.example.Proxym.service.fascade.DevisService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class DevisServiceImpl implements DevisService {
    DevisDAO devisDAO ;
    ModelMapper modelMapper ;
    AssureDAO assureDAO ;
    ProduitDAO produitDAO ;
    @Autowired
    public DevisServiceImpl(DevisDAO devisDAO, ModelMapper modelMapper, AssureDAO assureDAO, ProduitDAO produitDAO) {
        this.devisDAO = devisDAO;
        this.modelMapper = modelMapper;
        this.assureDAO = assureDAO;
        this.produitDAO = produitDAO;
    }





    @Override
    public Long save(DevisRequestDTO devisRequestDTO) {
        long assureId =devisRequestDTO.getAssureId() ;
        long produitId = devisRequestDTO.getProduitId();
        Assure assureEntity = assureDAO.findById(assureId)
                .orElseThrow(() -> new EntityNotFoundException("Assure not found"));

        Produit produitEntity = produitDAO.findById(produitId)
                .orElseThrow(() -> new EntityNotFoundException("Produit not found"));

        Devis devisEntity = modelMapper.map(devisRequestDTO , Devis.class) ;
        devisEntity.setId(null);
        devisEntity.setAssure(assureEntity);
        devisEntity.setProduit(produitEntity);
        Devis saved = devisDAO.save(devisEntity) ;
        return saved.getId();
    }

    @Override
    public DevisResponseDTO findById(Long id) {
        Devis devisEntity =devisDAO.findById(id).orElseThrow(()-> new EntityNotFoundException("Devis not found "));
        return modelMapper.map(devisEntity, DevisResponseDTO.class);
    }

    @Override
    public void delete(Long id) {
        devisDAO.findById(id).orElseThrow(() -> new EntityNotFoundException("Assure Not Found"));
        devisDAO.deleteById(id) ;

    }

    @Override
    public DevisResponseDTO update(DevisRequestDTO devisRequestDTO, Long id) {
        Optional<Devis> devisEntityOptional = devisDAO.findById(id);
        if (devisEntityOptional.isPresent()) {
            Devis devisEntity  = modelMapper.map(devisRequestDTO, Devis.class);
            devisEntity.setId(id);



            Devis updated = devisDAO.save(devisEntity);
            return modelMapper.map(updated, DevisResponseDTO.class);
        } else {
            throw new EntityNotFoundException("Devis Not Found");
        }
    }

    @Override
    public List<DevisResponseDTO> findAll() {
        return devisDAO.findAll()
                .stream()
                .map(e -> {
                    DevisResponseDTO devisResponseDTO = modelMapper.map(e, DevisResponseDTO.class);
                    devisResponseDTO.setProduitId(e.getProduit().getIdProduit());
                    devisResponseDTO.setAssureId(e.getAssure().getIdAssure());
                    return devisResponseDTO;
                })
                .collect(Collectors.toList());
    }

    @Override
    public double calculDevis(long produitId, Integer duree, long assureId) {
        Produit produit = produitDAO.findById(produitId)
                .orElseThrow(() -> new EntityNotFoundException("Produit not found"));

        Assure assure = assureDAO.findById(assureId)
                .orElseThrow(() -> new EntityNotFoundException("Assure not found"));

        ProduitLabel typeCouverture = produit.getLabel();

        double tarifMensuel;
        switch (typeCouverture) {
            case AUTO:
                tarifMensuel = 50;
                break;
            case MRH:
                tarifMensuel = 60;
                break;
            default:
                tarifMensuel = 70;
                break;
        }

        double montantTotal = tarifMensuel * duree;

        Devis devis = new Devis();

        devis.setDuree(duree);
        devis.setMontantTotal(montantTotal);
        devis.setProduit(produit);
        devis.setAssure(assure);

        boolean accepted = true ;

        if (accepted) {
            devisDAO.save(devis);
        }

        DevisResponseDTO devisResponseDTO = modelMapper.map(devis, DevisResponseDTO.class);
        devisResponseDTO.setAssureId(assureId);
        devisResponseDTO.setProduitId(produitId);
        devisResponseDTO.setMontantTotal(montantTotal);

        return devisResponseDTO.getMontantTotal() ;
    }

}
