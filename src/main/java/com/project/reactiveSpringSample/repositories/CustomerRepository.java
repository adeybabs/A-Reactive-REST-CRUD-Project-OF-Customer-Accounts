package com.project.reactiveSpringSample.repositories;

import com.project.reactiveSpringSample.model.Customer;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface CustomerRepository extends ReactiveCrudRepository<Customer, Integer> {

}
