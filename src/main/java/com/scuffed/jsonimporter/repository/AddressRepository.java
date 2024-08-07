package com.scuffed.jsonimporter.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.scuffed.jsonimporter.model.Address;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {
	
	Optional<Address> findFirstByStreetAndPlzAndCity(String street, Integer plz, String city);
	
}