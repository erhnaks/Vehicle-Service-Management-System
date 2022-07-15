package com.qa.may.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.qa.may.entity.Vehicle;

@Service
public class VehicleServiceList implements VehicleService {

	private Map<Integer, Vehicle> cars = new HashMap<>();

	@Override
	public Vehicle getById(int id) {
		return this.cars.get(id);
	}

	@Override
	public List<Vehicle> getAll() {
		return new ArrayList<Vehicle>(this.cars.values());
	}

	@Override
	public Vehicle findByVrm(String vrm) {
		for (Vehicle vehicle : this.cars.values()) {
			if (vehicle.getVrm().equals(vrm))

				return vehicle;
		}
		return null;
	}

	@Override
	public Vehicle create(Vehicle vehicle) {
		this.cars.put(vehicle.getId(), vehicle);
		return this.cars.get(vehicle.getId());
	}


	@Override
	public Vehicle update(int id, String vrm, Integer mileage, String description, Double cost) {
		Vehicle toUpdate = this.cars.get(id);

		if (vrm != null)
			toUpdate.setVrm(vrm);
		if (mileage != 0)
			toUpdate.setMileage(mileage);
		if (description != null)
			toUpdate.setDescription(description);
		if (cost != null)
			toUpdate.setCost(cost);
		this.cars.put(id, toUpdate);
		return toUpdate;
	}

	@Override
	public Vehicle updateByPatch(int id, String vrm, Integer mileage, String description, Double cost) {
		Vehicle toUpdate = this.cars.get(id);

		if (vrm != null)
			toUpdate.setVrm(vrm);
		if (mileage != 0)
			toUpdate.setMileage(mileage);
		if (description != null)
			toUpdate.setDescription(description);
		if (cost != null)
			toUpdate.setCost(cost);
		this.cars.put(id, toUpdate);
		return toUpdate;
	}
	
	@Override
	public void delete(int id) {
		this.cars.remove(id);
	}


}
