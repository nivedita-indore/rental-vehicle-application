package com.vehicle_rental_agency.entity;

import java.sql.Blob;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class VehicleBooking {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @NotNull(message = "Customer is required")
    private Customer customer;

    @ManyToOne
    @NotNull(message = "Vehicle is required")
    private Vehicle vehicle;

    @NotNull(message = "Booking Date is required")
    private String bookingDate;
    
    @Lob
    private Blob data;
}
