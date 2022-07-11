package com.qa.may.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.qa.may.entity.Vehicle;

@Repository

public interface VehicleRepo extends JpaRepository<Vehicle, Integer> {

	Vehicle findByVrmStartingWithIgnoreCase(String vrm);

}
