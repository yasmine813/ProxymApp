package com.example.Proxym.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Assure implements Serializable {
    @Id
    @GeneratedValue()
    private Long idAssure ;
    private String email ;
    private String name ;
    private String password ;
    private String numTel ;
    private Date dateIncrit ;



    @OneToOne(fetch = FetchType.LAZY , cascade = CascadeType.ALL)
    @JoinColumn(name ="address_id" )
    private Address address ;


}
