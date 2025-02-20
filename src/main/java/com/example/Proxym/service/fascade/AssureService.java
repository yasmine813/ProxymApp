package com.example.Proxym.service.fascade;

import com.example.Proxym.Entities.Contrat;
import com.example.Proxym.Repository.ContratDAO;
import com.example.Proxym.dto.AssureDTO.AssureRequestDTO;
import com.example.Proxym.dto.AssureDTO.AssureResponseDTO;
import org.springframework.data.crossstore.ChangeSetPersister;

import java.util.List;

public interface AssureService {
    AssureResponseDTO save(AssureRequestDTO assureRequestDTO);

    AssureResponseDTO findById(Long id) ;

    AssureResponseDTO findByName(String name) ;

    void delete(Long id) ;

    AssureResponseDTO update(AssureRequestDTO assureRequestDTO , Long id ) throws ChangeSetPersister.NotFoundException;

    List<AssureResponseDTO> findAll();

    AssureResponseDTO findByIdAddress(Long idAddress ) ;











}
