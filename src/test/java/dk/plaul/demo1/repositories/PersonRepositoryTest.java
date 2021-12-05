package dk.plaul.demo1.repositories;

import dk.plaul.demo1.entity.Customer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class PersonRepositoryTest {

    @Autowired
    CustomerRepository personRepository;

    @BeforeEach
    void setUp() {}
    @Test
    public void dbCountTest(){
        long count = personRepository.count();
        assertEquals(3,count);
    }

    @Test
    public void demoTest(){
        var persons = personRepository.findAll();
        persons.forEach(p -> System.out.println(p.getId() +", " + p.getFirstName()));
        var customer = personRepository.save(new Customer("Kurt","Wonnegut","kw@kw.com"));
        System.out.println(customer.getId());
    }

    @Test
    public void demoTest2(){
        var customers = personRepository.findAll();
        customers.forEach(p -> System.out.println(p.getId() +", " + p.getFirstName()));
        var customer = personRepository.save(new Customer("Kurt","Wonnegut","kw@kw.com"));
        System.out.println(customer.getId());
    }
}