package de.gedoplan.whatsnewinjee8.validation.constraint;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import de.gedoplan.whatsnewinjee8.validation.validator.AddressValidator;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

/**
 * BV Constraint for Address.
 *
 * @author dw
 */
@Constraint(validatedBy = AddressValidator.class)
@Target({ FIELD, METHOD, TYPE })
@Retention(RUNTIME)
public @interface ValidAddress {
  String message() default "{de.gedoplan.bvdemo.validation.constraint.ValidAddress.message}";

  Class<?>[] groups() default {};

  Class<? extends Payload>[] payload() default {};
}
