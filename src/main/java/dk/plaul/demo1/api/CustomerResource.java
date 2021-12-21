package dk.plaul.demo1.api;

import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dk.plaul.demo1.entity.Customer;
import dk.plaul.demo1.repositories.CustomerRepository;
import dk.plaul.demo1.errors.NotFoundException;

@RestController
@RequestMapping("/api/person")
public class CustomerResource {

  CustomerRepository personRepository;

  public CustomerResource(CustomerRepository personRepository) {
    this.personRepository = personRepository;
  }


  @GetMapping("/msg")
  String getMsg() {
    return "{\"msg\": \"Hej Erik\"";
  }
  @GetMapping
  Iterable<Customer> getAll() {
    Iterable<Customer> all = personRepository.findAll();
    return all;
  }

  @GetMapping("/{id}")
  Customer getOne(@PathVariable("id") int id) {
    return personRepository.findById(id).orElseThrow(() -> new NotFoundException("User not found"));
  }

  @PostMapping()
  Customer addOne(@RequestBody Customer customer) {return personRepository.save(customer); }

  @PutMapping("/{id}")
  Customer editOne(@RequestBody Customer person, @PathVariable("id") int id) {
    // We will change this to handle error
    var p = personRepository.findById(id).get();
    p.setFirstName(person.getFirstName());
    p.setLastName(person.getLastName());
    return personRepository.save(p);
  }

  @DeleteMapping("/{id}")
  void deleteOne(@PathVariable("id") int id) {
    personRepository.deleteById(id);
  }

}
