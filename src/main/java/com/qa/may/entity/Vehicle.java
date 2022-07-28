package com.qa.may.entity;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Vehicle {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String vrm; // Vehicle Registration Mark
	private Integer mileage;
	private String description;
	private Double cost;

	public Vehicle() {
		super();

	}

	public Vehicle(Integer id, String vrm, Integer mileage, String description, Double cost) {
		super();
		this.id = id;
		this.vrm = vrm;
		this.mileage = mileage;
		this.description = description;
		this.cost = cost;
	}

	public Vehicle(String vrm, Integer mileage, String description, Double cost) {
		super();
		this.vrm = vrm;
		this.mileage = mileage;
		this.description = description;
		this.cost = cost;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getVrm() {
		return vrm;
	}

	public void setVrm(String vrm) {
		this.vrm = vrm;
	}

	public Integer getMileage() {
		return mileage;
	}

	public void setMileage(Integer mileage) {
		this.mileage = mileage;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Double getCost() {
		return cost;
	}

	public void setCost(Double cost) {
		this.cost = cost;
	}

	@Override
	public String toString() {
		return "Vehicle [id=" + id + ", vrm=" + vrm + ", mileage=" + mileage + ", description=" + description
				+ ", cost=" + cost + "]";
	}

}
