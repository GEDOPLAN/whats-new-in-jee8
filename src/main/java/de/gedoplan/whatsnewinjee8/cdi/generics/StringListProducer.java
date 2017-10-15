package de.gedoplan.whatsnewinjee8.cdi.generics;

import java.util.Arrays;
import java.util.List;

import javax.enterprise.context.Dependent;
import javax.enterprise.inject.Produces;

@Dependent
public class StringListProducer {

  @Produces
  List<String> produceStringList() {
    return Arrays.asList("Ene", "mene", "Muh");
  }
}
