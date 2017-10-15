package de.gedoplan.whatsnewinjee8.cdi.generics;

import java.util.Arrays;
import java.util.List;

import javax.enterprise.context.Dependent;
import javax.enterprise.inject.Produces;

@Dependent
public class IntegerListProducer {

  @Produces
  List<Integer> produceStringList() {
    return Arrays.asList(1, 2, 3);
  }
}
