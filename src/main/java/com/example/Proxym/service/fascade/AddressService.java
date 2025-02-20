package com.example.Proxym.service.fascade;

import com.example.Proxym.dto.AddressDTO.AddressRequestDTO;
import com.example.Proxym.dto.AddressDTO.AddressResponseDTO;

import java.util.List;

public interface AddressService {
     AddressResponseDTO save(AddressRequestDTO addressRequestDTO) ;
     AddressResponseDTO update(AddressRequestDTO addressRequestDTO , Long id ) ;

     List<AddressResponseDTO> findAll() ;

}
