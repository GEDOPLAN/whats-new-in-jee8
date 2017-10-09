package de.gedoplan.whatsnewinjee8.cdi;

import de.gedoplan.whatsnewinjee8.cdi.service.HelloWorldService;

import javax.inject.Inject;

import org.junit.Test;

public class HelloWorldServiceTest extends CdiTestBase {

  @Inject
  HelloWorldService helloWorldService;

  @Test
  public void testHelloWorld() throws Exception {
    System.out.println(this.helloWorldService.getHelloWorld());
  }
}
