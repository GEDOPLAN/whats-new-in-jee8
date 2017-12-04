package de.gedoplan.whatsnewinjee8.cdi.qualifier;

import java.lang.annotation.Documented;
import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.*;

import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.inject.Qualifier;
import de.gedoplan.whatsnewinjee8.cdi.qualifier.Greeting.List;

@Qualifier
@Retention(RUNTIME)
@Target({ METHOD, FIELD, PARAMETER, TYPE })
@Repeatable(List.class)
@Documented
public @interface Greeting {

  GreetingType type();

  /**
   * Defines several {@link Greeting} annotations on the same element.
   *
   * @see javax.validation.constraints.NotNull
   */
  @Target({ METHOD, FIELD, PARAMETER, TYPE })
  @Retention(RUNTIME)
  @Documented
  @interface List {

    Greeting[] value();
  }

}
