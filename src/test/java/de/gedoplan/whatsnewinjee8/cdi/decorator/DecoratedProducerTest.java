package de.gedoplan.whatsnewinjee8.cdi.decorator;

import de.gedoplan.whatsnewinjee8.cdi.CdiTestBase;

import javax.inject.Inject;

import org.apache.commons.logging.Log;
import org.junit.Test;

public class DecoratedProducerTest extends CdiTestBase {
  @Inject
  Log log;

  @Test
  public void test_01_testInfo() throws Exception {
    this.log.info("Tolle Meldung");
  }
}
