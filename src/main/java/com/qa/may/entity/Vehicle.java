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
	private String description;
	private Double cost;

	public Vehicle() {
		super();

	}

	public Vehicle(String vrm, String description, Double cost) {
		super();
		this.vrm = vrm;
		this.description = description;
		this.cost = cost;
	}

	public Vehicle(Integer id, String vrm, String description, Double cost) {
		super();
		this.id = id;
		this.vrm = vrm;
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
	public int hashCode() {
		return Objects.hash(cost, description, id, vrm);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Vehicle other = (Vehicle) obj;
		return Objects.equals(cost, other.cost) && Objects.equals(description, other.description)
				&& Objects.equals(id, other.id) && Objects.equals(vrm, other.vrm);
	}

	@Override
	public String toString() {
		return "Vehicle [id=" + id + ", vrm=" + vrm + ", description=" + description + ", cost=" + cost + "]";
	}

}
