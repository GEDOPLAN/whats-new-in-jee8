package de.gedoplan.whatsnewinjee8.cdi.qualifier;

import static org.junit.Assert.*;

import de.gedoplan.whatsnewinjee8.cdi.CdiTestBase;

import javax.inject.Inject;

import org.apache.commons.logging.Log;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class GreetingServiceTest extends CdiTestBase {
  @Inject
  GreetingService defaultGreetingService;

  @Inject
  @Greeting(type = GreetingType.NORMAL)
  GreetingService normalGreetingService;

  @Inject
  @Greeting(type = GreetingType.COLLOQUIAL)
  GreetingService colloqialGreetingService;

  @Inject
  @Greeting(type = GreetingType.NORMAL)
  @Greeting(type = GreetingType.COLLOQUIAL)
  GreetingService normalAndColloqialGreetingService;

  @Inject
  @Greeting(type = GreetingType.FORMAL)
  GreetingService formalGreetingService;

  @Inject
  Log log;

  @Test
  public void test_01_Default() throws Exception {
    String greeting = this.defaultGreetingService.getGreeting();
    this.log.debug("Default greeting: " + greeting);

    assertNotEquals("Dear Madams and Sirs", greeting);
  }

  @Test
  public void test_02_Normal() throws Exception {
    String greeting = this.normalGreetingService.getGreeting();
    this.log.debug("Normal greeting: " + greeting);

    assertNotEquals("Dear Madams and Sirs", greeting);
  }

  @Test
  public void test_03_Colloqial() throws Exception {
    String greeting = this.colloqialGreetingService.getGreeting();
    this.log.debug("Colloqial greeting: " + greeting);

    assertNotEquals("Dear Madams and Sirs", greeting);
  }

  @Test
  public void test_04_NormalAndColloqial() throws Exception {
    String greeting = this.normalAndColloqialGreetingService.getGreeting();
    this.log.debug("Normal and colloqial greeting: " + greeting);

    assertNotEquals("Dear Madams and Sirs", greeting);
  }

  @Test
  public void test_05_Formal() throws Exception {
    String greeting = this.formalGreetingService.getGreeting();
    this.log.debug("Formal greeting: " + greeting);

    assertEquals("Dear Madams and Sirs", greeting);
  }
}
