package com.vehicle_rental_agency.service;

import java.util.List;
import com.vehicle_rental_agency.entity.Customer;

public interface CustomerService {
	
	public Customer saveCustomer(Customer customer);
	
	public List<Customer> getAllCustomers();
}
