package de.gedoplan.whatsnewinjee8.cdi.qualifier;

import java.util.Calendar;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Default;

@ApplicationScoped
@Default
@Greeting(type = GreetingType.NORMAL)
@Greeting(type = GreetingType.COLLOQUIAL)
public class NormalGreetingService implements GreetingService {

  @Override
  public String getGreeting() {
    int hourOfDay = Calendar.getInstance().get(Calendar.HOUR_OF_DAY);
    if (hourOfDay < 10) {
      return "Good morning";
    } else if (hourOfDay < 18) {
      return "Good afternoon";
    } else {
      return "Good evening";
    }

  }
}
