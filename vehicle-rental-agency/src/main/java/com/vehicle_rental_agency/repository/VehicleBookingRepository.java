package com.vehicle_rental_agency.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.vehicle_rental_agency.entity.VehicleBooking;

public interface VehicleBookingRepository extends JpaRepository<VehicleBooking, Long> {

}
