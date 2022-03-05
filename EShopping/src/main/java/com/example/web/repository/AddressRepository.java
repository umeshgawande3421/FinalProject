package com.example.web.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.web.model.Address;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long>{

}
