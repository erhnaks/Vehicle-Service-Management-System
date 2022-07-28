package com.qa.may.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.qa.may.entity.Vehicle;

@Repository

public interface VehicleRepo extends JpaRepository<Vehicle, Integer> {

	List <Vehicle> findByVrmStartingWithIgnoreCase(String vrm); //Will help the technician easily search for a record using Vehicle Registration Number;

}
