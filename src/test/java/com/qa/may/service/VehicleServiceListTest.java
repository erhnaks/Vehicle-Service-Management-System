package com.qa.may.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import com.qa.may.entity.Vehicle;
import com.qa.may.rest.VehicleController;

@SpringBootTest(classes = VehicleServiceList.class)
@ActiveProfiles("test")
public class VehicleServiceListTest {

	@Autowired
	private VehicleService vehicleService;

	@BeforeEach
	public void initial() {
		Vehicle vehicle = new Vehicle(1, "LT68KUD", 1000, "Serviced", 9.99);

		vehicleService.create(vehicle);
	}

	@Test
	public void getById_WithVehicleId_ShouldReturnVehicle() {

		Vehicle result = vehicleService.getById(1);

		assertNotNull(result);

		assertEquals(1, result.getId());
		assertEquals("LT68KUD", result.getVrm());

	}

	@Test
	public void getAll_ShouldReturnAllVehicles() {

		List<Vehicle> vehicles = vehicleService.getAll();

		assertFalse(vehicles.isEmpty());
		assertTrue(vehicles.size() == 1);

	}

	@Test
	public void findByVrm_ShouldReturnVrm() {

		Vehicle result = vehicleService.findByVrm("LT68KUD");

		assertNotNull(result);
		assertEquals(1, result.getId());
		assertEquals("LT68KUD", result.getVrm());

	}

	@Test
	public void update_ShouldReturnUpdated() {

		Vehicle result = vehicleService.update(1, "LM68", 1000, "Serviced", 10.00);

		assertNotNull(result);
		assertEquals(1, result.getId());
		assertEquals("LM68", result.getVrm());
		assertEquals(1000, result.getMileage());
		assertEquals("Serviced", result.getDescription());
		assertEquals(10.00, result.getCost());
	}

	@Test
	public void updateByPatch_ShouldReturnUpdated() {

		Vehicle result = vehicleService.updateByPatch(1, "XX10XXX", 2000, "Oil Changed", 99.00);

		assertNotNull(result);
		assertEquals(1, result.getId());
		assertEquals("XX10XXX", result.getVrm());
		assertEquals(2000, result.getMileage());
		assertEquals("Oil Changed", result.getDescription());
		assertEquals(99.00, result.getCost());
	}
	
	@Test
	public void deleteTest_ShouldDelete() {
		vehicleService.delete(1);
		
		return;
		
		
	
	}
	
	
	
	

}
