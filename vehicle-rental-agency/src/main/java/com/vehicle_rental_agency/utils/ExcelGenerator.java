package com.vehicle_rental_agency.utils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.vehicle_rental_agency.entity.Customer;
import com.vehicle_rental_agency.entity.Vehicle;
import com.vehicle_rental_agency.entity.VehicleBooking;

import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.HttpServletResponse;

public class ExcelGenerator {

	private List<Vehicle> vehicleList;
	private List<Customer> customerList;
	
	private XSSFWorkbook workbook;// reading or writing a workbook. It is also the top level object for creating
									// new sheets/etc.
	private XSSFSheet sheet;// Worksheet cells cancontain text, numbers, dates, and formulas. Cells can also
	private XSSFSheet sheet1;					// be formatted.
	private XSSFSheet vehicleBookingData;
	
	public ExcelGenerator(List <Vehicle> bookedVehicle,List<Customer> customerData) {
		this.vehicleList = bookedVehicle;
		this.customerList=customerData;
		workbook = new XSSFWorkbook();
	}

	private void writeHeader() {
		sheet = workbook.createSheet("Vehicle");
		Row row = sheet.createRow(0);
		CellStyle style = workbook.createCellStyle();
		XSSFFont font = workbook.createFont();
		font.setBold(true);
		font.setFontHeight(16);
		style.setFont(font);

		createCell(row, 0, "vehicle Id", style);
		createCell(row, 1, "vehicleCategory", style);
		createCell(row, 2, "manufacturer", style);
		createCell(row, 3, "dailyRent", style);
		createCell(row, 4, "mileage", style);
		createCell(row, 5, "fuelType", style);
		createCell(row, 6, "description", style);
		
		sheet1 = workbook.createSheet("Customer");
		Row row1 = sheet1.createRow(0);
		CellStyle style1 = workbook.createCellStyle();
		XSSFFont font1 = workbook.createFont();
		font1.setBold(true);
		font1.setFontHeight(16);
		style1.setFont(font1);

		createCell(row1, 0, "Customer Id", style1);
		createCell(row1, 1, "Name", style1);
		createCell(row1, 2, "Email", style1);
		createCell(row1, 3, "Phone Number", style1);
		
		vehicleBookingData = workbook.createSheet("Vehicle Booking List");
		Row row3 = vehicleBookingData.createRow(0);
		CellStyle style3 = workbook.createCellStyle();
		XSSFFont font3 = workbook.createFont();
		font3.setBold(true);
		font3.setFontHeight(16);
		style3.setFont(font3);
		
		createCell(row3, 0, "Customer Id", style3);
		createCell(row3, 1, "Name", style3);
		createCell(row3, 2, "Email", style3);
		createCell(row3, 3, "Phone Number", style3);
		createCell(row3, 4, "vehicle Id", style3);
		createCell(row3, 5, "vehicleCategory", style3);
		createCell(row3, 6, "manufacturer", style3);
		createCell(row3, 7, "dailyRent", style3);
		createCell(row3, 8, "mileage", style3);
		createCell(row3, 9, "fuelType", style3);
		createCell(row3, 10, "description", style3);
		
		
	}

	private void createCell(Row row, int columnCount, Object valueOfCell, CellStyle style) {
		sheet.autoSizeColumn(columnCount);
		Cell cell = row.createCell(columnCount);
		if (valueOfCell instanceof Integer) {
			cell.setCellValue((Integer) valueOfCell);
		} else if (valueOfCell instanceof Long) {
			cell.setCellValue((Long) valueOfCell);
		} else if (valueOfCell instanceof String) {
			cell.setCellValue((String) valueOfCell);
		}else if (valueOfCell instanceof Double) {
			cell.setCellValue((double) valueOfCell);
		}
		else {
			cell.setCellValue((Boolean) valueOfCell);
		}
		cell.setCellStyle(style);
	}

	private void write() {
		int rowCount = 1;
		CellStyle style = workbook.createCellStyle();
		XSSFFont font = workbook.createFont();
		font.setFontHeight(14);
		style.setFont(font);
		for (Vehicle record : vehicleList) {
			Row row = sheet.createRow(rowCount++);
			int columnCount = 0;
			createCell(row, columnCount++, record.getId(), style);
			createCell(row, columnCount++, record.getVehicleCategory(), style);
			createCell(row, columnCount++, record.getManufacturer(), style);
			createCell(row, columnCount++, record.getDailyRent(), style);
			createCell(row, columnCount++, record.getMileage(), style);
			createCell(row, columnCount++, record.getFuelType(), style);
			createCell(row, columnCount++, record.getDescription(), style);
		}
		
		int rowCount1 = 1;
		CellStyle style1 = workbook.createCellStyle();
		XSSFFont font1 = workbook.createFont();
		font1.setFontHeight(14);
		style1.setFont(font1);
		for (Customer record : customerList) {
			Row row = sheet1.createRow(rowCount1++);
			int columnCount = 0;
			createCell(row, columnCount++, record.getId(), style1);
			createCell(row, columnCount++, record.getName(), style1);
			createCell(row, columnCount++, record.getEmail(), style1);
			createCell(row, columnCount++, record.getPhoneNumber(), style1);
		}
		/*
		 * int rowCount2 = 1; CellStyle style3 = workbook.createCellStyle(); XSSFFont
		 * font3 = workbook.createFont(); font.setFontHeight(14); style3.setFont(font3);
		 * List<VehicleBooking> list = new ArrayList<>(); VehicleBooking
		 * booking=VehicleBooking.builder().customer(customerList).vehicle(vehicleList).
		 * build(); list.add(booking); for (VehicleBooking record : list) {
		 * 
		 * Row row = vehicleBookingData.createRow(rowCount++); int columnCount = 0;
		 * createCell(row, columnCount++, record.getCustomer().get(0).getId(), style3);
		 * createCell(row, columnCount++, record.getCustomer().get(0).getName(),
		 * style3); createCell(row, columnCount++,
		 * record.getCustomer().get(0).getEmail(), style3); createCell(row,
		 * columnCount++, record.getCustomer().get(0).getPhoneNumber(), style3);
		 * createCell(row, columnCount++, record.getVehicle().get(1).getId(), style3);
		 * createCell(row, columnCount++,
		 * record.getVehicle().get(1).getVehicleCategory(), style3); createCell(row,
		 * columnCount++, record.getVehicle().get(1).getManufacturer(), style3);
		 * createCell(row, columnCount++, record.getVehicle().get(1).getDailyRent(),
		 * style3); createCell(row, columnCount++,
		 * record.getVehicle().get(1).getMileage(), style3); createCell(row,
		 * columnCount++, record.getVehicle().get(1).getFuelType(), style3);
		 * createCell(row, columnCount++, record.getVehicle().get(1).getDescription(),
		 * style3);
		 * 
		 * 
		 * }
		 */
		

	}

	public void generateExcelFile(HttpServletResponse response) throws IOException {
		writeHeader();
		write();
		ServletOutputStream outputStream = response.getOutputStream();
		workbook.write(outputStream);
		workbook.close();
		outputStream.close();
	}
	
}
