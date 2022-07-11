package com.qa.may.service;

import java.util.List;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.qa.may.entity.Vehicle;

@Service
@Primary
public class VehicleServiceDB implements VehicleService {

	@Override
	public Vehicle getById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Vehicle> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Vehicle findByVrm(String vrm) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Vehicle create(Vehicle vehicle) {
		// TODO Auto-generated method stub
		return null;
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
