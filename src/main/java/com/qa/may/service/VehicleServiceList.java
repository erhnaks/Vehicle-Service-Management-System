package com.qa.may.service;

import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.qa.may.entity.Vehicle;

@Service
public class VehicleServiceList implements VehicleService {

	private List<Vehicle> cars = new LinkedList<>();

	@Override
	public Vehicle getById(int id) {
		return this.cars.get(id);
	}

	@Override
	public List<Vehicle> getAll() {
		return this.cars;
	}

	@Override
	public Vehicle findByVrm(String vrm) {
		for (Vehicle vehicle : this.cars) {
			if (vehicle.getVrm().equals(vrm))

				return vehicle;
		}
		return null;
	}

	@Override
	public Vehicle create(Vehicle vehicle) {
		this.cars.add(vehicle);
		return this.cars.get(this.cars.size() - 1);
	}

	@Override
	public Vehicle update(int id, String vrm, String description, Double cost) {
		Vehicle toUpdate = this.cars.get(id);

		if (vrm != null)
			toUpdate.setVrm(vrm);
		if (description != null)
			toUpdate.setDescription(description);
		if (cost != null)
			toUpdate.setCost(cost);
		return toUpdate;
	}

	@Override
	public void delete(int id) {
		this.cars.remove(id);
	}

	@Override
	public Vehicle updateByPatch(int id, String vrm, String description, Double cost) {

		Vehicle toUpdate = this.cars.get(id);

		if (vrm != null)
			toUpdate.setVrm(vrm);
		if (description != null)
			toUpdate.setDescription(description);
		if (cost != null)
			toUpdate.setCost(cost);
		return toUpdate;

	}

}
