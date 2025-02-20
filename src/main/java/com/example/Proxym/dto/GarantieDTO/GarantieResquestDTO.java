package com.example.Proxym.dto.GarantieDTO;

import com.example.Proxym.Entities.Produit;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.CascadeType;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GarantieResquestDTO {
    private String code ;
    private String label ;
    private String limite ;
    private double franchise ;
    private Long produitId ;
}
