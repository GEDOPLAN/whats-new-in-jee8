package de.gedoplan.whatsnewinjee8.webservice;

import javax.ws.rs.sse.SseEventSource;

import org.junit.Test;

public class SseServiceTest extends RestTestBase {

  @Test
  public void testSse() throws Exception {
    try (SseEventSource sseEventSource = SseEventSource.target(baseTarget.path("sse")).build()) {
      sseEventSource.register(e -> log.debug("Event received: " + e));
      sseEventSource.open();

      // Process incoming events for 10 seconds
      Thread.sleep(10000);
    }
  }
}
