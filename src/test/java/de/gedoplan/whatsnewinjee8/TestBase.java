package de.gedoplan.whatsnewinjee8;

import org.junit.BeforeClass;

public class TestBase {

  @BeforeClass
  public static void initLogging() {
    System.setProperty("java.util.logging.manager", "org.apache.logging.log4j.jul.LogManager");
  }
}
