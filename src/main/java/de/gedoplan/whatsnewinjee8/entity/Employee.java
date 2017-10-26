package de.gedoplan.whatsnewinjee8.entity;

import de.gedoplan.baselibs.persistence.entity.SingleIdEntity;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Entity
@Access(AccessType.FIELD)
@Getter
@Setter
public class Employee extends SingleIdEntity<Integer> {
  @Id
  private Integer id;
  private String name;

  private Address address;

  @AttributeOverride(name = "street", column = @Column(name = "HOME_STREET"))
  @AttributeOverride(name = "zipCode", column = @Column(name = "HOME_ZIPCODE"))
  @AttributeOverride(name = "city", column = @Column(name = "HOME_CITY"))
  private Address homeAddress;

  private double salary;

  protected Employee() {
  }

  public Employee(Integer id, String name, double salary) {
    this.id = id;
    this.name = name;
    this.salary = salary;
  }

}
