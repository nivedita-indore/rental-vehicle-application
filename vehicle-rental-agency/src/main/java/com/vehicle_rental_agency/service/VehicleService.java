package com.vehicle_rental_agency.service;

import java.util.List;

import com.vehicle_rental_agency.entity.Vehicle;

public interface VehicleService {
	
	Vehicle saveVehicle(Vehicle vehicle);
	
    List<Vehicle> getAllVehicles(); 
}
