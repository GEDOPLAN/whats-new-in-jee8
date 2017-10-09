package de.gedoplan.whatsnewinjee8.cdi.service;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class HelloWorldService {
  public String getHelloWorld() {
    return "Hello, world!";
  }
}
