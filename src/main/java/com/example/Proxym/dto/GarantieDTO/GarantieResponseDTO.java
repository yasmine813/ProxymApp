package com.example.Proxym.dto.GarantieDTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GarantieResponseDTO {
    private Long id ;
    private String code ;
    private String label ;
    private String limite ;
    private double franchise ;
    private Long produitId ;
}
