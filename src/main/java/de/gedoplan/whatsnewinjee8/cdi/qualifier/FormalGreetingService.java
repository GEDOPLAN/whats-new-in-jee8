package de.gedoplan.whatsnewinjee8.cdi.qualifier;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
@Greeting(type = GreetingType.FORMAL)
public class FormalGreetingService implements GreetingService {

  @Override
  public String getGreeting() {
    return "Dear Madams and Sirs";
  }

}
