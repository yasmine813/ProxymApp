package com.example.Proxym.dto.AddressDTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddressResponseDTO {
    private Long idAddress ;
    private String city ;
    private String street ;
    private Integer streetNum ;
    private String postCode ;

}
