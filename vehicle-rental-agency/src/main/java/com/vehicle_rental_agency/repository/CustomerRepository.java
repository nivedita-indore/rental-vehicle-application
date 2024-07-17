package com.vehicle_rental_agency.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.vehicle_rental_agency.entity.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long>{

}
