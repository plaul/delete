package dk.plaul.demo1.repositories;


import org.springframework.data.repository.CrudRepository;

import dk.plaul.demo1.entity.Customer;

public interface CustomerRepository extends CrudRepository<Customer,Integer> {

}

