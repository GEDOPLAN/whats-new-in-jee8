package de.gedoplan.whatsnewinjee8.cdi.qualifier;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.*;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

@Target({ PARAMETER, FIELD, METHOD, TYPE })
@Retention(RUNTIME)
public @interface Greetings {
  Greeting[] value();
}
