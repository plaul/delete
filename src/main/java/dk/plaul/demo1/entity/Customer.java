package dk.plaul.demo1.entity;

import java.time.LocalDateTime;

import javax.persistence.*;

import org.hibernate.annotations.CreationTimestamp;

@Entity
public class Customer {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int customerId;

  @Column(nullable = false,length=30)
  private String firstName;

  @Column(nullable = false,length = 50)
  private String lastName;

  @Column(nullable = false,length = 60)
  private String email;

  
  private String managerId;
  private String customerRating;
  @CreationTimestamp
  private LocalDateTime created;


  public Customer(String firstName, String lastName, String email) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.email = email;
  }

  public Customer() {
  }

  public int getId() {
    return customerId;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public String getCustomerRating() {
    return customerRating;
  }

  public void setCustomerRating(String customerRating) {
    this.customerRating = customerRating;
  }

  public LocalDateTime getCreated() {
    return created;
  }

  public void setCreated(LocalDateTime created) {
    this.created = created;
  }
}
