package com.citizen.api.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the customer database table.
 * 
 */
@Entity
@NamedQuery(name="Customer.findAll", query="SELECT c FROM Customer c")
public class Customer implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private int accountId;

	private int citipointAccId;

	private String name;

	public Customer() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getAccountId() {
		return this.accountId;
	}

	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}

	public int getCitipointAccId() {
		return this.citipointAccId;
	}

	public void setCitipointAccId(int citipointAccId) {
		this.citipointAccId = citipointAccId;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

}