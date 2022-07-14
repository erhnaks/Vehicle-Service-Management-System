package com.qa.may.rest;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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

	@GetMapping("/getAll")
	public List<Vehicle> getAll() {

		return this.service.getAll();
	}

	@GetMapping("/registration/{vrm}")
	public Vehicle findByVrm(@PathVariable String vrm) {
		return this.service.findByVrm(vrm);
	}

	@PostMapping("/create")
	public ResponseEntity<Vehicle> create(@RequestBody Vehicle vehicle) {

		System.out.println("Created: " + vehicle);

		Vehicle created = this.service.create(vehicle);

		return new ResponseEntity<Vehicle>(created, HttpStatus.CREATED);

	}

	@PatchMapping("/updateByPatch/{id}")
	public Vehicle updateByPatch(@PathVariable("id") int id, @PathParam("vrm") String vrm, @PathParam("mileage") Integer mileage, 
			@PathParam("description") String description, @PathParam("cost") Double cost) {

		return this.service.updateByPatch(id, vrm, mileage, description, cost);
	}

	@PutMapping("/update/{id}")
	public Vehicle update(@PathVariable("id") int id, @PathParam("vrm") String vrm, @PathParam("mileage") Integer mileage,
			@PathParam("description") String description, @PathParam("cost") Double cost) {

		return this.service.update(id, vrm, mileage, description, cost);
	}

	@DeleteMapping("/remove/{id}")
	public ResponseEntity<?> delete(@PathVariable int id) {
		this.service.delete(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

}
