package com.example.Proxym.dto.ProduitDTO;

import com.example.Proxym.Entities.ProduitLabel;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProduitRequestDTO {
    private String code ;

    private ProduitLabel label ;
}
