package com.qa.may.rest;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.patch;
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
@AutoConfigureMockMvc // Setting up the testing class
@Sql(scripts = { "classpath:vehicle-schema.sql",
		"classpath:vehicle-data.sql" }, executionPhase = ExecutionPhase.BEFORE_TEST_METHOD)
@ActiveProfiles("test")
public class VehicleControllerIntegrationTest {

	@Autowired
	private MockMvc mvc;

	@Autowired
	private ObjectMapper mapper;

	@Test
	void testCreate() throws Exception {
		Vehicle testVehicle = new Vehicle("VU13VYB", 1000, "Serviced", 19.99);
		String testVehicleAsJSON = this.mapper.writeValueAsString(testVehicle);
		RequestBuilder req = post("/create").content(testVehicleAsJSON).contentType(MediaType.APPLICATION_JSON);

		ResultMatcher checkStatus = MockMvcResultMatchers.status().is(201);
		Vehicle createdVehicle = new Vehicle(2, "VU13VYB", 1000, "Serviced", 19.99);
		String createdVehicleAsJSON = this.mapper.writeValueAsString(createdVehicle);
		ResultMatcher checkBody = MockMvcResultMatchers.content().json(createdVehicleAsJSON);

		this.mvc.perform(req).andExpect(checkStatus).andExpect(checkBody);
	}

	@Test
	void testUpdate() throws Exception {
		Vehicle updatedVehicle = new Vehicle(1, "LM68ESN", 1000, "Serviced", 9.99);
		String toJSON = this.mapper.writeValueAsString(updatedVehicle);
		ResultMatcher checkBody = MockMvcResultMatchers.content().json(toJSON);

		this.mvc.perform(put("/update/1?vrm=LM68ESN&mileage=1000&description=Serviced&cost=9.99")).andExpect(checkBody)
				.andExpect(status().isOk());
	}

	@Test
	void testUpdateByPatch() throws Exception {
		Vehicle updatedVehicle = new Vehicle(1, "LM68ESN", 1000, "Serviced", 9.99);
		String toJSON = this.mapper.writeValueAsString(updatedVehicle);
		ResultMatcher checkBody = MockMvcResultMatchers.content().json(toJSON);

		this.mvc.perform(patch("/updateByPatch/1?vrm=LM68ESN&mileage=1000&description=Serviced&cost=9.99"))
				.andExpect(checkBody).andExpect(status().isOk());
	}

	@Test
	void testReadByAll() throws Exception {

		List<Vehicle> readVehicles = new ArrayList<>();
		readVehicles.add(new Vehicle(1, "LT68KUD", 1000, "Serviced", 99.00));
		String createdVehicleAsJSON = this.mapper.writeValueAsString(readVehicles);

		this.mvc.perform(get("/getAll")).andExpect(content().json(createdVehicleAsJSON)).andExpect(status().isOk());

	}

	@Test
	void testReadById() throws Exception {

		Vehicle readVehicle = new Vehicle(1, "LT68KUD", 1000, "Serviced", 99.00);
		String createdVehicleAsJSON = this.mapper.writeValueAsString(readVehicle);

		this.mvc.perform(get("/readById/1")).andExpect(content().json(createdVehicleAsJSON)).andExpect(status().isOk());

	} // get url //body

	@Test
	void testFindByVrm() throws Exception {

		Vehicle readVehicleByVrm = new Vehicle(1, "LT68KUD", 1000, "Serviced", 99.00);
		String createdVehicleAsJSON = this.mapper.writeValueAsString(readVehicleByVrm);

		this.mvc.perform(get("/registration/lt68kud")).andExpect(content().json(createdVehicleAsJSON))
				.andExpect(status().isOk());

	}

	@Test
	void testDelete() throws Exception {
		this.mvc.perform(delete("/remove/1")).andExpect(status().isNoContent());
	}

}
