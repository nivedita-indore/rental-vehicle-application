package com.vehicle_rental_agency.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.sql.rowset.serial.SerialException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.vehicle_rental_agency.entity.Customer;
import com.vehicle_rental_agency.entity.Vehicle;
import com.vehicle_rental_agency.entity.VehicleBooking;
import com.vehicle_rental_agency.service.CustomerService;
import com.vehicle_rental_agency.service.VehicleBookingDetailService;
import com.vehicle_rental_agency.service.VehicleService;
import com.vehicle_rental_agency.utils.ExcelGenerator;

import jakarta.servlet.http.HttpServletResponse;

@RestController
public class VehicleBookingController {

	@Autowired
	private VehicleBookingDetailService bookingService;
	
	@Autowired
	private VehicleService vehicleService;
	
	@Autowired
	private CustomerService customerService; 
	
	@GetMapping("/export-to-excel")
    public void exportIntoExcelFile(HttpServletResponse response) throws IOException {
        response.setContentType("application/octet-stream");
        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
        String currentDateTime = dateFormatter.format(new Date());

        String headerKey = "Content-Disposition";
        String headerValue = "attachment; filename=vehicleData" + currentDateTime + ".xlsx";
        response.setHeader(headerKey, headerValue);

        List <Vehicle> bookedVehicle = vehicleService.getAllVehicles();
        List<Customer> customerData = customerService.getAllCustomers();
        
       ExcelGenerator generator = new ExcelGenerator(bookedVehicle, customerData);
       generator.generateExcelFile(response);
        
	}   
	
	@PostMapping(value = "/fileUpload",consumes = {"multipart/form-data"} )
	public VehicleBooking saveDetails(VehicleBooking data ,@RequestPart(value = "file" ,required = false) MultipartFile file) throws IOException, SerialException, SQLException {
		VehicleBooking allData = bookingService.save(data, file);
		return allData;
	}
}
