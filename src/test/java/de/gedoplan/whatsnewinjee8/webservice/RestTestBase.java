package de.gedoplan.whatsnewinjee8.webservice;

import de.gedoplan.whatsnewinjee8.TestBase;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.AfterClass;
import org.junit.BeforeClass;

public class RestTestBase extends TestBase {
  protected static Client client;
  protected static WebTarget baseTarget;

  protected static Log log = LogFactory.getLog(RxServiceTest.class);

  @BeforeClass
  public static void beforeClass() {
    client = ClientBuilder.newClient();

    baseTarget = client.target("http://localhost:8080/whats-new-in-jee8/rest");
  }

  @AfterClass
  public static void afterClass() {
    client.close();
  }
}
