package com.citizen.api.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the pointtsn database table.
 * 
 */
@Entity
@NamedQuery(name="Pointtsn.findAll", query="SELECT p FROM Pointtsn p")
public class Pointtsn implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private double amount;

	private int causeId;

	private int customerId;

	@Temporal(TemporalType.DATE)
	private Date date;

	public Pointtsn() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getAmount() {
		return this.amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public int getCauseId() {
		return this.causeId;
	}

	public void setCauseId(int causeId) {
		this.causeId = causeId;
	}

	public int getCustomerId() {
		return this.customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public Date getDate() {
		return this.date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

}