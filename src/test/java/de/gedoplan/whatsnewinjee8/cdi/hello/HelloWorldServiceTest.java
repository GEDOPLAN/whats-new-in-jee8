package de.gedoplan.whatsnewinjee8.cdi.hello;

import de.gedoplan.whatsnewinjee8.cdi.CdiTestBase;

import javax.inject.Inject;

import org.apache.commons.logging.Log;
import org.junit.Test;

public class HelloWorldServiceTest extends CdiTestBase {

  @Inject
  HelloWorldService helloWorldService;

  @Inject
  Log log;

  @Test
  public void testHelloWorld() throws Exception {
    this.log.debug(this.helloWorldService.getHelloWorld());
  }
}
