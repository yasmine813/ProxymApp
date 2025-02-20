package com.example.Proxym.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.util.Date;
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Devis {
    @Id
    @GeneratedValue()
    private Long id;
    private String nomEntrepriseAss;
    private String siegeSocial;
    private String etenduesGarantis;
    private Integer duree;
    private Integer numCategorieAss;
    private String modaliteVersementPrimes;
    private Date delaiModeliteRealisationContrat;
    private Date dateSouscription;
    private double montantTotal ;
    @ManyToOne(fetch = FetchType.LAZY )
    @JoinColumn(name = "assureId")
    @JsonIgnore

    private Assure assure ;
    @ManyToOne(fetch = FetchType.EAGER )
    @JoinColumn(name ="produitId" )
    @JsonIgnore
    private Produit produit;
    @OneToOne(mappedBy = "devis")
    private Contrat contrat;

}
