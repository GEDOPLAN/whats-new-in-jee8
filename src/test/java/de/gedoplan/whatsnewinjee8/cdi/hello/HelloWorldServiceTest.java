package de.gedoplan.whatsnewinjee8.cdi.hello;

import de.gedoplan.baselibs.utils.util.ClassUtil;
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

    this.log.debug("Class:         " + this.helloWorldService.getClass());
    this.log.debug("Proxied class: " + ClassUtil.getProxiedClass(this.helloWorldService.getClass()));
  }
}
