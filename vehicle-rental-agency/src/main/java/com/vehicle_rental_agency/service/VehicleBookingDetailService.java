package com.vehicle_rental_agency.service;

import java.io.IOException;
import java.nio.file.Path;
import java.sql.SQLException;
import java.util.List;
import java.util.stream.Stream;

import javax.sql.rowset.serial.SerialException;

import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;


import com.vehicle_rental_agency.entity.VehicleBooking;

public interface VehicleBookingDetailService {

	  public void init();

	  public VehicleBooking save(VehicleBooking departmentFile ,MultipartFile file) throws IOException, SerialException, SQLException;

	  public Resource load(String filename);

	  public void deleteAll();

	  public Stream<Path> loadAll();
}
