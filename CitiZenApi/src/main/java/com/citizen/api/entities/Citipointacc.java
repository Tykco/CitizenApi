package com.citizen.api.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the citipointacc database table.
 * 
 */
@Entity
@NamedQuery(name="Citipointacc.findAll", query="SELECT c FROM Citipointacc c")
public class Citipointacc implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private long id;

	private double balance;

	private int customerId;

	public Citipointacc() {
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public double getBalance() {
		return this.balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public int getCustomerId() {
		return this.customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

}