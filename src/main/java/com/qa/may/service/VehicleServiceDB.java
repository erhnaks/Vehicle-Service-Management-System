package com.qa.may.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import com.qa.may.entity.Vehicle;
import com.qa.may.repo.VehicleRepo;

@Service
@Primary
public class VehicleServiceDB implements VehicleService {

	@Autowired
	private VehicleRepo repo;

	@Override
	public Vehicle getById(int id) {

		return this.repo.findById(id).get();
	}

	@Override
	public List<Vehicle> getAll() {
		return this.repo.findAll();
	}

	@Override
	public List<Vehicle> findByVrm(String vrm) {
		return this.repo.findByVrmStartingWithIgnoreCase(vrm);
	}

	@Override
	public Vehicle create(Vehicle vehicle) {
		return this.repo.save(vehicle);
	}

	@Override
	public void delete(int id) {
		this.repo.deleteById(id);
	}

	@Override
	public Vehicle update(int id, String vrm, Integer mileage, String description, Double cost) {

		Vehicle toUpdate = this.getById(id);

		if (vrm != null)
			toUpdate.setVrm(vrm);
		if (mileage != 0)
			toUpdate.setMileage(mileage);
		if (description != null)
			toUpdate.setDescription(description);
		if (cost != null)
			toUpdate.setCost(cost);
		return this.repo.save(toUpdate);
	}

}
