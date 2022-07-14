package com.qa.may.service;

import java.util.List;

import com.qa.may.entity.Vehicle;

public interface VehicleService {

	Vehicle getById(int id);

	List<Vehicle> getAll();

	Vehicle findByVrm(String vrm);

	Vehicle create(Vehicle vehicle);

	Vehicle update(int id, String vrm, int mileage, String description, Double cost);

	void delete(int id);

	Vehicle updateByPatch(int id, String vrm, int mileage, String description, Double cost);

}
