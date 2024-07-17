package com.vehicle_rental_agency.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.vehicle_rental_agency.entity.Vehicle;
import com.vehicle_rental_agency.repository.VehicleRepository;

@Service
public class VehicleServiceImpl implements VehicleService {
	@Autowired
    private VehicleRepository vehicleRepository;
	
	@Override
	public Vehicle saveVehicle(Vehicle vehicle) {
		return vehicleRepository.save(vehicle);
	}

	@Override
	public List<Vehicle> getAllVehicles() {
		return vehicleRepository.findAll();
	}

}
