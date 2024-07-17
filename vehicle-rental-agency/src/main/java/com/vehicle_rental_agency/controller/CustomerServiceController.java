package com.vehicle_rental_agency.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.vehicle_rental_agency.entity.Customer;
import com.vehicle_rental_agency.service.CustomerService;

@RestController
public class CustomerServiceController {

	@Autowired
	private CustomerService customerService;

	@PostMapping("/customerDetail")
	public Customer saveCustomerData(@RequestBody Customer customer) {
		return customerService.saveCustomer(customer);

	}

	@GetMapping("/customerList")
	public List<Customer> featchCustomerDetails() {
		return customerService.getAllCustomers();

	}
}
