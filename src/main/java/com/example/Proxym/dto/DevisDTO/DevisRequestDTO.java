package com.example.Proxym.dto.DevisDTO;

import com.example.Proxym.Entities.ProduitLabel;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DevisRequestDTO {
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
