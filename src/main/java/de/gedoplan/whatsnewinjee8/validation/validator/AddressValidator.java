package de.gedoplan.whatsnewinjee8.validation.validator;

import de.gedoplan.whatsnewinjee8.entity.Address;
import de.gedoplan.whatsnewinjee8.validation.constraint.ValidAddress;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * BV Validator for constraint {@link ValidAddress}.
 *
 * Addresses are valid, if their components are completely <code>null</code> or not <code>null</code>.
 *
 * @author dw
 */
public class AddressValidator implements ConstraintValidator<ValidAddress, Address> {
  @Override
  public void initialize(ValidAddress constraint) {
  }

  @Override
  public boolean isValid(Address adresse, ConstraintValidatorContext validationContext) {
    // null is ok
    if (adresse == null) {
      return true;
    }

    // every attribute null is ok
    if (adresse.getCity() == null && adresse.getZipCode() == null && adresse.getStreet() == null) {
      return true;
    }

    // For demo of generating individual messages: If ZIP code is "00000" ...
    if ("00000".equals(adresse.getZipCode())) {
      // ... disable default message
      validationContext.disableDefaultConstraintViolation();

      // ... add message for validated object
      validationContext.buildConstraintViolationWithTemplate("{de.gedoplan.bvdemo.validation.constraint.ValidAddress.zipCode.message}").addPropertyNode("zipCode").addConstraintViolation();

      return false;
    }

    // every attribute filled is ok
    if (adresse.getCity() != null && adresse.getZipCode() != null && adresse.getStreet() != null) {
      return true;
    }

    return false;
  }
}
