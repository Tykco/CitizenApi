package com.citizen.api.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the citipointrate database table.
 * 
 */
@Entity
@NamedQuery(name="Citipointrate.findAll", query="SELECT c FROM Citipointrate c")
public class Citipointrate implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private double rate;

	public Citipointrate() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getRate() {
		return this.rate;
	}

	public void setRate(double rate) {
		this.rate = rate;
	}

}