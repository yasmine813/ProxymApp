package com.example.Proxym.Repository;

import com.example.Proxym.Entities.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressDAO extends JpaRepository<Address ,Long> {

}
