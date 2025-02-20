package com.example.Proxym.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Simulateur {
    @Id
    @GeneratedValue
    private Integer idSimulateur ;
    private String typeCouverture;
    private Integer duree;
    private double montantTotal;
    private double tarifMensuel;


}
