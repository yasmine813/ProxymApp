package com.example.Proxym.service.impl;

import com.example.Proxym.Entities.Address;
import com.example.Proxym.Entities.Assure;
import com.example.Proxym.Repository.AddressDAO;
import com.example.Proxym.dto.AddressDTO.AddressRequestDTO;
import com.example.Proxym.dto.AddressDTO.AddressResponseDTO;
import com.example.Proxym.dto.AssureDTO.AssureResponseDTO;
import com.example.Proxym.exception.EntityNotFoundException;
import com.example.Proxym.service.fascade.AddressService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AddressServiceImpl implements AddressService {

    AddressDAO addressDAO ;
    ModelMapper modelMapper ;
    @Autowired
    public AddressServiceImpl(AddressDAO addressDAO , ModelMapper modelMapper) {
        this.addressDAO = addressDAO;
        this.modelMapper = modelMapper ;
    }

    @Override
    public AddressResponseDTO save(AddressRequestDTO addressRequestDTO) {
        Address addressEntity = modelMapper.map(addressRequestDTO,Address.class) ;
        Address saved = addressDAO.save(addressEntity) ;
        return modelMapper.map(saved, AddressResponseDTO.class) ;
    }

    @Override
    public AddressResponseDTO update(AddressRequestDTO addressRequestDTO, Long id) {
        Optional<Address> addressEntityOptional = addressDAO.findById(id) ;
        if (addressEntityOptional.isPresent()) {
            Address addressEntity = modelMapper.map(addressRequestDTO, Address.class);
            addressEntity.setIdAddress(id);



            Address updated = addressDAO.save(addressEntity);
            return modelMapper.map(updated, AddressResponseDTO.class);
        } else {
            throw new EntityNotFoundException("Address Not Found");
        }
    }


    @Override
    public List<AddressResponseDTO> findAll() {
        return addressDAO.findAll()
                .stream()
                .map(e -> modelMapper.map(e, AddressResponseDTO.class))
                .collect(Collectors.toList());
    }
}
