package com.example.Proxym.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Produit {
    @Id
    @GeneratedValue()
    private Long idProduit ;
    private String code ;
    @Enumerated(EnumType.STRING)
    private  ProduitLabel label ;

    @OneToMany(mappedBy = "produit" )
    private List<Garantie> Garanties ;
    
}
