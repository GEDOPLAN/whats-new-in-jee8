package de.gedoplan.whatsnewinjee8.cdi.qualifier;

//CHECKSTYLE:OFF

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.*;

import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.inject.Qualifier;

@Qualifier
@Retention(RUNTIME)
@Target({ METHOD, FIELD, PARAMETER, TYPE })
@Repeatable(Greetings.class)
public @interface Greeting {
  GreetingType type();
}
