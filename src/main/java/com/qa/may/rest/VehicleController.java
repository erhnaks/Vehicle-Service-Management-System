package com.qa.may.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.qa.may.entity.Vehicle;
import com.qa.may.service.VehicleService;

@RestController
public class VehicleController {

	@Autowired
	private VehicleService service;

	@GetMapping("/readById/{id}")
	public Vehicle getById(@PathVariable int id) {

		return this.service.getById(id);
	}

	@GetMapping("/carGetAll")
	public List<Vehicle> getAll() {

		return this.service.getAll();
	}

	@PostMapping("/create")
	public ResponseEntity<Vehicle> create(@RequestBody Vehicle vehicle) {

		System.out.println("Created: " + vehicle);

		Vehicle created = this.service.create(vehicle);

		return new ResponseEntity<Vehicle>(created, HttpStatus.CREATED);

	}

}
