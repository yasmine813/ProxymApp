package com.example.Proxym.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Garantie {
    @Id
    @GeneratedValue()
    private Long id ;
    private String code ;
    private String label ;
    private String limite ;
    private double franchise ;
    @ManyToOne()
    @JoinColumn(name = "produitId")
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private Produit produit ;

}
