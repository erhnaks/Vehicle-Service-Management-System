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
	public Vehicle findByVrm(String vrm) {
		return this.repo.findByVrmStartingWithIgnoreCase(vrm);
	}

	@Override
	public Vehicle create(Vehicle vehicle) {
		return this.repo.save(vehicle);
	}

	@Override
	public Vehicle update(int id, String vrm, String description, Double cost) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub

	}

	@Override
	public Vehicle updateByPatch(int id, String vrm, String description, Double cost) {
		// TODO Auto-generated method stub
		return null;
	}

}
