package com.vehicle_rental_agency.service;

import java.io.IOException;
import java.nio.file.Path;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.stream.Stream;

import javax.sql.rowset.serial.SerialBlob;
import javax.sql.rowset.serial.SerialException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.vehicle_rental_agency.entity.VehicleBooking;
import com.vehicle_rental_agency.repository.CustomerRepository;
import com.vehicle_rental_agency.repository.VehicleBookingRepository;

@Service
public class VehicleBookingServiceImpl implements VehicleBookingDetailService{
	@Autowired
    private VehicleBookingRepository bookingRepository;
	
	@Autowired
	private VehicleBookingRepository vehicleBookingRepository;
	
	@Autowired
	private CustomerRepository customerRepository;

	@Override
	public void init() {
		
	}

	@Override
	public VehicleBooking save(VehicleBooking vehicleDetailFile, MultipartFile file)
			throws IOException, SerialException, SQLException {
		Blob blob = new SerialBlob(file.getBytes());
		vehicleDetailFile.setData(blob);
	//	System.out.println("====="+vehicleDetailFile);
		return vehicleBookingRepository.save(vehicleDetailFile);

	}

	@Override
	public Resource load(String filename) {
		return null;
	}

	@Override
	public void deleteAll() {		
	}

	@Override
	public Stream<Path> loadAll() {
		return null;
	}

}
