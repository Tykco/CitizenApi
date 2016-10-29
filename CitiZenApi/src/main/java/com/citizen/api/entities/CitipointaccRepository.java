package com.citizen.api.entities;

import org.springframework.data.repository.CrudRepository;

public interface CitipointaccRepository extends CrudRepository<Citipointacc, Long> {

	public Citipointacc findByCustomerId(int customerId);

}
