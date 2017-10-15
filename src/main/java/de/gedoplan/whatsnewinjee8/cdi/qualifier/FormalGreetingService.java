package de.gedoplan.whatsnewinjee8.cdi.qualifier;

@Greeting(type = GreetingType.FORMAL)
public class FormalGreetingService implements GreetingService {

  @Override
  public String getGreeting() {
    return "Dear Madams and Sirs";
  }

}
