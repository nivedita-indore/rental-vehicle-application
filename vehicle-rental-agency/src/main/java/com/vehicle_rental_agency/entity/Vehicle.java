package com.vehicle_rental_agency.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Vehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Registration Number is required")
    @Pattern(regexp = "^[A-Z]{2}[0-9]{2}-[A-Z]{2}-[0-9]{4}$", message = "Invalid Registration Number format (e.g. KA06-AB-8765)")
    private String registrationNumber;

    @NotBlank(message = "Vehicle Category is required")
    private String vehicleCategory; 

    @NotBlank(message = "Manufacturer is required")
    private String manufacturer;

    @NotNull(message = "Daily Rent is required")
    private Double dailyRent;

    @NotNull(message = "Mileage is required")
    private Double mileage; 

    @NotBlank(message = "Fuel type is required")
    private String fuelType; 

    private String description; 


}
