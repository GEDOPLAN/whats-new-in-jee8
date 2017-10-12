package de.gedoplan.whatsnewinjee8.cdi.hello;

import de.gedoplan.whatsnewinjee8.cdi.CdiTestBase;

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
