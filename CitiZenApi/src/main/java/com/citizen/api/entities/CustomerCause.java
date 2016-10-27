package com.citizen.api.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the customer_cause database table.
 * 
 */
@Entity
@Table(name="customer_cause")
@NamedQuery(name="CustomerCause.findAll", query="SELECT c FROM CustomerCause c")
public class CustomerCause implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private int causeId;

	private int customerId;

	public CustomerCause() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
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

}