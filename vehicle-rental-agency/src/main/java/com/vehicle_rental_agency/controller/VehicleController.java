package com.vehicle_rental_agency.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.vehicle_rental_agency.entity.Vehicle;
import com.vehicle_rental_agency.service.VehicleService;

@RestController
public class VehicleController {

	@Autowired
	VehicleService vehicleService;

	@PostMapping("/vehicle")
	public Vehicle saveVehicle(@RequestBody Vehicle vehicle) {
		return vehicleService.saveVehicle(vehicle);
	}

	@GetMapping("/vehicleList")
	public List<Vehicle> featchVehicleList() {
		return vehicleService.getAllVehicles();
	}
}
