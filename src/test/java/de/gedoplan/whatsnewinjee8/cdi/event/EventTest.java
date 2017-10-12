package de.gedoplan.whatsnewinjee8.cdi.event;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

import de.gedoplan.whatsnewinjee8.cdi.CdiTestBase;

import javax.inject.Inject;

import org.junit.Test;

public class EventTest extends CdiTestBase {

  @Inject
  EventProducer eventProducer;

  @Test
  public void testSyncEvent() throws Exception {
    DemoEvent demoEvent = this.eventProducer.fireSyncEvent();

    assertThat(demoEvent.getLog(), contains("a", "A", "b", "B", "c", "C", "M"));
  }

  @Test
  public void testAsyncEvent() throws Exception {
    DemoEvent demoEvent = this.eventProducer.fireAsyncEvent();

    assertThat(demoEvent.getLog(), containsInAnyOrder("M", "x", "X", "y", "!Y", "z", "!Z"));
  }
}
