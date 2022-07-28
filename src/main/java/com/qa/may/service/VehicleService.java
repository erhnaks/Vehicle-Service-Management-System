package com.qa.may.service;

import java.util.List;

import com.qa.may.entity.Vehicle;

public interface VehicleService {

	Vehicle getById(int id);

	List<Vehicle> getAll();

	List<Vehicle> findByVrm(String vrm);

	Vehicle create(Vehicle vehicle);

	void delete(int id);

	Vehicle update(int id, String vrm, Integer mileage, String description, Double cost);

}
