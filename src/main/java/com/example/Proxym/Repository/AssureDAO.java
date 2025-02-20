package com.example.Proxym.Repository;

import com.example.Proxym.Entities.Assure;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface AssureDAO extends JpaRepository<Assure,Long> {
    Assure findByName(String nom) ;
    Assure findAssureByAddress_IdAddress(Long id ) ;
}
