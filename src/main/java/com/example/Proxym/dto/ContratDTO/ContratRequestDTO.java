package com.example.Proxym.dto.ContratDTO;

import com.example.Proxym.Entities.Assure;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class ContratRequestDTO {
    private String nomEntrepriseAss;
    private String siegeSocial;
    private String etenduesGarantis;
    private Integer duree;
    private Integer numCategorieAss;
    private String modaliteVersementPrimes;
    private Date delaiModeliteRealisationContrat;
    private Date dateSouscription;
    private double montantTotal ;
    private Long assureId;
    private Long produitId;


}
