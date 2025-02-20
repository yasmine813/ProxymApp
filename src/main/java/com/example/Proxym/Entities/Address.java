package com.example.Proxym.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Address {
    @Id
    @GeneratedValue()
    private Long idAddress ;
    private String city ;
    private String street ;
    private Integer streetNum ;
    private String postCode ;
    @OneToOne(mappedBy = "address")
    private Assure assure ;

}
