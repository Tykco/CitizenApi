package com.citizen.api.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the cause database table.
 * 
 */
@Entity
@NamedQuery(name="Cause.findAll", query="SELECT c FROM Cause c")
public class Cause implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private int citipointAccId;

	private double cost;

	private String description;

	private String name;

	private int organizationId;

	public Cause() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCitipointAccId() {
		return this.citipointAccId;
	}

	public void setCitipointAccId(int citipointAccId) {
		this.citipointAccId = citipointAccId;
	}

	public double getCost() {
		return this.cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getOrganizationId() {
		return this.organizationId;
	}

	public void setOrganizationId(int organizationId) {
		this.organizationId = organizationId;
	}

}