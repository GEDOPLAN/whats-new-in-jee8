package de.gedoplan.whatsnewinjee8.cdi.service;

import javax.enterprise.context.Dependent;

@Dependent
public class HelloWorldService {
  public String getHelloWorld() {
    return "Hello, world!";
  }
}
