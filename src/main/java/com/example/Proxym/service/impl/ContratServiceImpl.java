package com.example.Proxym.service.impl;

import com.example.Proxym.Entities.Assure;
import com.example.Proxym.Entities.Contrat;
import com.example.Proxym.Entities.Devis;
import com.example.Proxym.Entities.Produit;
import com.example.Proxym.Repository.AssureDAO;
import com.example.Proxym.Repository.ContratDAO;
import com.example.Proxym.Repository.DevisDAO;
import com.example.Proxym.Repository.ProduitDAO;
import com.example.Proxym.dto.ContratDTO.ContratRequestDTO;
import com.example.Proxym.dto.ContratDTO.ContratResponseDTO;
import com.example.Proxym.exception.EntityNotFoundException;
import com.example.Proxym.service.fascade.ContratService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service

public class ContratServiceImpl implements ContratService {
    ContratDAO contratDAO ;
    AssureDAO assureDAO;
    ModelMapper modelMapper ;
    ProduitDAO produitDAO ;
    DevisDAO devisDAO ;

    @Autowired
    public ContratServiceImpl(ContratDAO contratDAO , ModelMapper modelMapper , AssureDAO assureDAO , ProduitDAO produitDAO ,  DevisDAO devisDAO) {
        this.contratDAO=contratDAO ;
        this.modelMapper = modelMapper ;
        this.assureDAO = assureDAO ;
        this.produitDAO =produitDAO ;
        this.devisDAO=devisDAO;
    }

    @Override
    public ContratResponseDTO save(ContratRequestDTO contratRequestDTO) {
        long assureId = contratRequestDTO.getAssureId();
        long produitId = contratRequestDTO.getProduitId();

        System.out.println("AssureId: " + assureId);
        System.out.println("ProduitId: " + produitId);

        Assure assureEntity = assureDAO.findById(assureId)
                .orElseThrow(() -> new EntityNotFoundException("Assure not found"));

        Produit produitEntity = produitDAO.findById(produitId)
                .orElseThrow(() -> new EntityNotFoundException("Produit not found"));


        Contrat contratEntity = new Contrat();

        contratEntity.setNomEntrepriseAss(contratRequestDTO.getNomEntrepriseAss());
        contratEntity.setSiegeSocial(contratRequestDTO.getSiegeSocial());

        contratEntity.setEtenduesGarantis(contratRequestDTO.getEtenduesGarantis());
        contratEntity.setDuree(contratRequestDTO.getDuree());
        contratEntity.setNumCategorieAss(contratRequestDTO.getNumCategorieAss());
        contratEntity.setModaliteVersementPrimes(contratRequestDTO.getModaliteVersementPrimes());
        contratEntity.setDelaiModeliteRealisationContrat(contratRequestDTO.getDelaiModeliteRealisationContrat());
        contratEntity.setDateSouscription(contratRequestDTO.getDateSouscription());
        contratEntity.setMontantTotal(contratRequestDTO.getMontantTotal());
        contratEntity.setAssure(assureEntity);
        contratEntity.setProduit(produitEntity);




        System.out.println("Constructed Contrat entity: " + contratEntity);

        Contrat saved = contratDAO.save(contratEntity);


        ContratResponseDTO contratResponseDTO = new ContratResponseDTO();
        contratResponseDTO.setId(saved.getId());
        contratResponseDTO.setNomEntrepriseAss(saved.getNomEntrepriseAss());
        contratResponseDTO.setSiegeSocial(saved.getSiegeSocial());

        contratResponseDTO.setEtenduesGarantis(saved.getEtenduesGarantis());
        contratResponseDTO.setDuree(saved.getDuree());
        contratResponseDTO.setNumCategorieAss(saved.getNumCategorieAss());
        contratResponseDTO.setModaliteVersementPrimes(saved.getModaliteVersementPrimes());
        contratResponseDTO.setDelaiModeliteRealisationContrat(saved.getDelaiModeliteRealisationContrat());
        contratResponseDTO.setDateSouscription(saved.getDateSouscription());
        contratResponseDTO.setMontantTotal(saved.getMontantTotal());
        contratResponseDTO.setAssureId(assureId);
        contratResponseDTO.setProduitId(produitId);


        System.out.println("Constructed ContratResponseDTO: " + contratResponseDTO);

        return contratResponseDTO;
    }

  /*  @Override
    public ContratResponseDTO save(ContratRequestDTO contratRequestDTO) {
         long assureId =contratRequestDTO.getAssureId() ;
         long produitId = contratRequestDTO.getProduitId();
         System.out.println("assureId :" + assureId);
         System.out.println(produitId);

        Assure assureEntity = assureDAO.findById(assureId)
                .orElseThrow(() -> new EntityNotFoundException("Assure not found"));

        Produit produitEntity = produitDAO.findById(produitId)
                .orElseThrow(() -> new EntityNotFoundException("Produit not found"));


        Contrat contratEntity = modelMapper.map(contratRequestDTO, Contrat.class);

        contratEntity.setId(null);
        contratEntity.setAssure(assureEntity);
        contratEntity.setProduit(produitEntity);

        Contrat saved = contratDAO.save(contratEntity);
        ContratResponseDTO contratResponseDTO =  modelMapper.map(saved, ContratResponseDTO.class);
        contratResponseDTO.setProduitId(produitId);
        contratResponseDTO.setAssureId(assureId);
        return  contratResponseDTO ;
    }

   */


    @Override
    public ContratResponseDTO findById(Long id) {
        Contrat contratEntity =contratDAO.findById(id).orElseThrow(()-> new EntityNotFoundException("Contrat not found "));
        ContratResponseDTO contratResponseDTO = modelMapper.map(contratEntity,ContratResponseDTO.class);
        contratResponseDTO.setAssureId(contratEntity.getAssure().getIdAssure());
        contratResponseDTO.setProduitId(contratEntity.getProduit().getIdProduit());
        return contratResponseDTO ;
    }

    @Override
    public void delete(Long id) {
        contratDAO.findById(id).orElseThrow(() -> new EntityNotFoundException("Assure Not Found"));
        contratDAO.deleteById(id) ;

    }

    @Override
    public ContratResponseDTO update(ContratRequestDTO contratRequestDTO, Long id) {

        Contrat contratEntity = contratDAO.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Contrat not found"));


        Assure assureEntity = assureDAO.findById(contratRequestDTO.getAssureId())
                .orElseThrow(() -> new EntityNotFoundException("Assure not found"));


        Produit produitEntity = produitDAO.findById(contratRequestDTO.getProduitId())
                .orElseThrow(() -> new EntityNotFoundException("Produit not found"));


        modelMapper.map(contratRequestDTO, contratEntity);


        contratEntity.setAssure(assureEntity);
        contratEntity.setProduit(produitEntity);


        Contrat updatedContrat = contratDAO.save(contratEntity);


        ContratResponseDTO contratResponseDTO = modelMapper.map(updatedContrat, ContratResponseDTO.class);
        contratResponseDTO.setAssureId(updatedContrat.getAssure().getIdAssure());
        contratResponseDTO.setProduitId(updatedContrat.getProduit().getIdProduit());

        return contratResponseDTO;
    }


    @Override
    public List<ContratResponseDTO> findAll() {
        return contratDAO.findAll()
                .stream()
                .map(e -> {
                    ContratResponseDTO contratResponseDTO = modelMapper.map(e, ContratResponseDTO.class);
                    contratResponseDTO.setProduitId(e.getProduit().getIdProduit());
                    contratResponseDTO.setAssureId(e.getAssure().getIdAssure());
                    return contratResponseDTO;
                })
                .collect(Collectors.toList());
    }


    @Override
    public List<ContratResponseDTO> getContractsByAssureId(Long assureId) {
        List<Contrat> contrats = contratDAO.findByAssureIdAssure(assureId);
        return contrats.stream()
                .map(e -> {
                    ContratResponseDTO contratResponseDTO = modelMapper.map(e, ContratResponseDTO.class);
                    contratResponseDTO.setProduitId(e.getProduit().getIdProduit());
                    contratResponseDTO.setAssureId(e.getAssure().getIdAssure());
                    return contratResponseDTO;
                })
                .collect(Collectors.toList());
    }


    @Override
    public List<ContratResponseDTO> getContratByProduitId(Long produitId) {
        List<Contrat> contrats = contratDAO.findByProduit_IdProduit(produitId);
        return contrats.stream()
                .map(e -> {
                    ContratResponseDTO contratResponseDTO = modelMapper.map(e, ContratResponseDTO.class);
                    contratResponseDTO.setProduitId(e.getProduit().getIdProduit());
                    contratResponseDTO.setAssureId(e.getAssure().getIdAssure());
                    return contratResponseDTO;
                })
                .collect(Collectors.toList());
    }


    @Override
    public ContratResponseDTO convertDevisToContrat(Long idDevis) {
        Devis devisEntity = devisDAO.findById(idDevis).orElseThrow(() -> new EntityNotFoundException("Devis not found")) ;
        Contrat contratEntity = modelMapper.map(devisEntity , Contrat.class) ;
        contratDAO.save(contratEntity) ;
        ContratResponseDTO contratResponseDTO = modelMapper.map(contratEntity, ContratResponseDTO.class) ;
        contratResponseDTO.setAssureId(devisEntity.getAssure().getIdAssure());
        contratResponseDTO.setProduitId(devisEntity.getProduit().getIdProduit());
        return  contratResponseDTO ;


    }


}

