package com.qa.may.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.qa.may.entity.Vehicle;
import com.qa.may.service.VehicleService;

@CrossOrigin
@RestController
public class VehicleController {

	@Autowired
	private VehicleService service;

	@GetMapping("/readById/{id}") // To find a record by its Id number;
	public Vehicle getById(@PathVariable int id) {

		return this.service.getById(id);
	}

	@GetMapping("/getAll") // Listing all of the saved entry to the database;
	public List<Vehicle> getAll() {

		return this.service.getAll();
	}

	@GetMapping("/registration/{vrm}") // Find an entry by using Vehicle registration mark;
	public List<Vehicle> findByVrm(@PathVariable String vrm) {
		return this.service.findByVrm(vrm);
	}

	@PostMapping("/create") //Create an entry to save it to the database;
	public ResponseEntity<Vehicle> create(@RequestBody Vehicle vehicle) {

		System.out.println("Created: " + vehicle);

		Vehicle created = this.service.create(vehicle);

		return new ResponseEntity<Vehicle>(created, HttpStatus.CREATED);

	}

	@PutMapping("/update/{id}") // Update an existing entry;
	public Vehicle update(@PathVariable("id") int id, @RequestBody Vehicle vehicle) {

		return this.service.update(id, vehicle.getVrm(), vehicle.getMileage(), vehicle.getDescription(),
				vehicle.getCost());
	}

	@DeleteMapping("/remove/{id}") // Remove an entry from the record! It will delete from the database permanently.
	public ResponseEntity<?> delete(@PathVariable int id) {
		this.service.delete(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

}
