package com.qa.may.rest;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.Sql.ExecutionPhase;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.qa.may.entity.Vehicle;

@SpringBootTest
@AutoConfigureMockMvc 
@Sql(scripts = { "classpath:vehicle-schema.sql",
		"classpath:vehicle-data.sql" }, executionPhase = ExecutionPhase.BEFORE_TEST_METHOD)
@ActiveProfiles("test")
public class VehicleControllerIntegrationTest {

	@Autowired
	private MockMvc mvc;

	@Autowired
	private ObjectMapper mapper;
	
	// Testing the create method;
	@Test
	void testCreate() throws Exception {
		Vehicle testVehicle = new Vehicle("VU13VYB", 1000, "Serviced", 19.99); // Giving a dummy entry data.
		String testVehicleAsJSON = this.mapper.writeValueAsString(testVehicle);
		RequestBuilder req = post("/create").content(testVehicleAsJSON).contentType(MediaType.APPLICATION_JSON);

		ResultMatcher checkStatus = MockMvcResultMatchers.status().is(201);
		Vehicle createdVehicle = new Vehicle(2, "VU13VYB", 1000, "Serviced", 19.99); //Excepting the giving data above with an ID.
		String createdVehicleAsJSON = this.mapper.writeValueAsString(createdVehicle);
		ResultMatcher checkBody = MockMvcResultMatchers.content().json(createdVehicleAsJSON);

		this.mvc.perform(req).andExpect(checkStatus).andExpect(checkBody);
	}
	// Testing update method;
	@Test
	void testUpdate() throws Exception {
		Vehicle updatedVehicle = new Vehicle(1, "LM68ESN", 1000, "Serviced", 9.99); // updating the original data which is given at the application resources for test purposes.
		String toJSON = this.mapper.writeValueAsString(updatedVehicle);
		ResultMatcher checkBody = MockMvcResultMatchers.content().json(toJSON);

		this.mvc.perform(put("/update/1").content(toJSON).contentType(MediaType.APPLICATION_JSON)).andExpect(checkBody)
				.andExpect(status().isOk());
	}
	// Reading all of the entry test
	@Test
	void testReadByAll() throws Exception {

		List<Vehicle> readVehicles = new ArrayList<>();
		readVehicles.add(new Vehicle(1, "LT68KUD", 1000, "Serviced", 99.00));
		String createdVehicleAsJSON = this.mapper.writeValueAsString(readVehicles);

		this.mvc.perform(get("/getAll")).andExpect(content().json(createdVehicleAsJSON)).andExpect(status().isOk());

	}
	// Reading by Id test;
	@Test
	void testReadById() throws Exception {

		Vehicle readVehicle = new Vehicle(1, "LT68KUD", 1000, "Serviced", 99.00);
		String createdVehicleAsJSON = this.mapper.writeValueAsString(readVehicle);

		this.mvc.perform(get("/readById/1")).andExpect(content().json(createdVehicleAsJSON)).andExpect(status().isOk());

	} // get url //body
	
	// Finding an existing entry by vrm test;
	@Test
	void testFindByVrm() throws Exception {

		List<Vehicle> readVehicleByVrm = new ArrayList< Vehicle>();
		readVehicleByVrm.add(new Vehicle(1, "LT68KUD", 1000, "Serviced", 99.00));
		String createdVehicleAsJSON = this.mapper.writeValueAsString(readVehicleByVrm);

		this.mvc.perform(get("/registration/lt68kud")).andExpect(content().json(createdVehicleAsJSON))
				.andExpect(status().isOk());

	}
	
	// delete an entry test;
	@Test
	void testDelete() throws Exception {
		this.mvc.perform(delete("/remove/1")).andExpect(status().isNoContent());
	}

}
