package de.gedoplan.whatsnewinjee8.entity;

import de.gedoplan.whatsnewinjee8.validation.constraint.ValidAddress;
import de.gedoplan.whatsnewinjee8.validation.group.InitialInput;

import java.io.Serializable;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import javax.validation.groups.Default;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@ValidAddress(groups = { InitialInput.class, Default.class })
public class Address implements Serializable {

  @Size(min = 1, groups = { InitialInput.class, Default.class })
  private String street;

  @Pattern(regexp = "\\d{5}", message = "must cointain exactly 5 digits", groups = { InitialInput.class, Default.class })
  private String zipCode;

  @Size(min = 1, groups = { InitialInput.class, Default.class })
  private String city;
}
