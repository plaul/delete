package dk.plaul.demo1.configuration;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import dk.plaul.demo1.entity.Customer;
import dk.plaul.demo1.repositories.CustomerRepository;


@Configuration
public class DataSetup implements CommandLineRunner {

  CustomerRepository personRepository;

  public DataSetup(CustomerRepository personRepository) {
    this.personRepository = personRepository;
  }

  @Override
  public void run(String... args) throws Exception {
    personRepository.deleteAll();
    personRepository.save(new Customer("Peter", "Olsen","po@somewhere.com"));
    personRepository.save(new Customer("Hanne", "Olsen","ho@somewhere.com"));
  }
}
