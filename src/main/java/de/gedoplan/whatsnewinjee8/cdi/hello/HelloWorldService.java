package de.gedoplan.whatsnewinjee8.cdi.hello;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class HelloWorldService {
  public String getHelloWorld() {
    return "Hello, world!";
  }
}
