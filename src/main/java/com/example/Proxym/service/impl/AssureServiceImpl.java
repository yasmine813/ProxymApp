package com.example.Proxym.service.impl;

import com.example.Proxym.Entities.Address;
import com.example.Proxym.Entities.Assure;
import com.example.Proxym.Entities.Contrat;
import com.example.Proxym.Repository.AddressDAO;
import com.example.Proxym.Repository.AssureDAO;
import com.example.Proxym.Repository.ContratDAO;
import com.example.Proxym.dto.AssureDTO.AssureRequestDTO;
import com.example.Proxym.dto.AssureDTO.AssureResponseDTO;
import com.example.Proxym.dto.ContratDTO.ContratResponseDTO;
import com.example.Proxym.exception.EntityNotFoundException;
import com.example.Proxym.service.fascade.AssureService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service

public class AssureServiceImpl implements AssureService {


     AssureDAO assureDAO ;
     ModelMapper modelMapper ;
     ContratDAO contratDAO ;
     AddressDAO addressDAO;

    @Autowired
    public AssureServiceImpl(AssureDAO assureDAO , ModelMapper modelMapper , AddressDAO addressDAO  ) {
        this.assureDAO = assureDAO  ;
        this.modelMapper = modelMapper ;
        this.addressDAO = addressDAO ;
    }

    @Override
    public AssureResponseDTO save(AssureRequestDTO assureRequestDTO) {
        long idAddress= assureRequestDTO.getIdAddress() ;

        Assure assureEntity = modelMapper.map(assureRequestDTO,Assure.class);
        Address addressEntity = addressDAO.findById(idAddress).orElseThrow(() -> new EntityNotFoundException("Address not found")) ;
        assureEntity.setAddress(addressEntity);


        Assure saved = assureDAO.save(assureEntity);
        AssureResponseDTO assureResponseDTO =  modelMapper.map(saved , AssureResponseDTO.class);
        assureResponseDTO.setIdAddress(idAddress);
        return  assureResponseDTO ;

            }



    @Override
    public AssureResponseDTO findById(Long id) {
        Assure assureEntity =assureDAO.findById(id).orElseThrow(()-> new EntityNotFoundException("Assure not found "));
        AssureResponseDTO assureResponseDTO =  modelMapper.map(assureEntity,AssureResponseDTO.class);
        assureResponseDTO.setIdAddress(assureEntity.getAddress().getIdAddress());
        return assureResponseDTO ;
    }

    @Override
    public AssureResponseDTO findByName(String name) {
    Assure assureEntity = assureDAO.findByName(name) ;

    if (assureEntity == null ) {
        throw new EntityNotFoundException("Assure Not Found") ;
    }

    AssureResponseDTO assureResponseDTO =  modelMapper.map(assureEntity,AssureResponseDTO.class) ;
    assureResponseDTO.setIdAddress(assureEntity.getAddress().getIdAddress());
    return  assureResponseDTO ;
    }

    @Override
    public void delete(Long id) {
         assureDAO.findById(id).orElseThrow(() -> new EntityNotFoundException("Assure Not Found"));
         assureDAO.deleteById(id);
    }

    @Override
    public AssureResponseDTO update(AssureRequestDTO assureRequestDTO , Long id)  throws ChangeSetPersister.NotFoundException {
        Optional<Assure> assureEntityOptional = assureDAO.findById(id);
        if (assureEntityOptional.isPresent()) {
            Assure assureEntity = modelMapper.map(assureRequestDTO, Assure.class);
            long addressId = assureRequestDTO.getIdAddress();
            assureEntity.setIdAssure(id);
            Address addressEntity = addressDAO.findById(addressId).orElseThrow(() -> new EntityNotFoundException("Address Not Found"));
            assureEntity.setAddress(addressEntity);



            Assure updated = assureDAO.save(assureEntity);
            AssureResponseDTO assureResponseDTO =  modelMapper.map(updated, AssureResponseDTO.class);
            assureResponseDTO.setIdAddress(addressId);
            return  assureResponseDTO ;
        } else {
            throw new EntityNotFoundException("Assure Not Found");
        }
    }
    @Override
    public List<AssureResponseDTO> findAll() {
        return assureDAO.findAll()
                .stream()
                .map(e -> {
                    AssureResponseDTO assureResponseDTO = modelMapper.map(e, AssureResponseDTO.class);
                    assureResponseDTO.setIdAddress(e.getAddress().getIdAddress());

                    return assureResponseDTO;
                })
                .collect(Collectors.toList());
    }

    @Override
    public AssureResponseDTO findByIdAddress(Long idAddress) {
        Assure assureEntity = assureDAO.findAssureByAddress_IdAddress(idAddress) ;
        AssureResponseDTO assureResponseDTO =  modelMapper.map(assureEntity, AssureResponseDTO.class);
        assureResponseDTO.setIdAddress(idAddress);
        return  assureResponseDTO ;

    }


}


