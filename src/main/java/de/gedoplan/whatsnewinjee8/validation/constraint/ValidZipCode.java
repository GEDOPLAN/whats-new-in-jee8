package de.gedoplan.whatsnewinjee8.validation.constraint;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;
import javax.validation.ReportAsSingleViolation;
import javax.validation.constraints.Pattern;

/**
 * BV Constraint für ZIP codes.
 *
 * @author dw
 */
@Constraint(validatedBy = {})
@Pattern(regexp = "\\d{5}")
@ReportAsSingleViolation
@Target({ FIELD, METHOD })
@Retention(RUNTIME)
public @interface ValidZipCode {
  String message() default "{de.gedoplan.bvdemo.validation.constraint.ValidZipCode.message}";

  Class<?>[] groups() default {};

  Class<? extends Payload>[] payload() default {};
}
