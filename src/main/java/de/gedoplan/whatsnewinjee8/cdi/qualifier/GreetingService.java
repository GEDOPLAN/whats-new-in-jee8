package de.gedoplan.whatsnewinjee8.cdi.qualifier;

import java.io.Serializable;

public interface GreetingService extends Serializable {
  public String getGreeting();
}
