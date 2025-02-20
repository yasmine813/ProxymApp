package com.example.Proxym.dto.ProduitDTO;

import com.example.Proxym.Entities.Contrat;
import com.example.Proxym.Entities.ProduitLabel;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProduitResponseDTO {
    private Long idProduit ;
    private String code ;
    private ProduitLabel label ;
}
