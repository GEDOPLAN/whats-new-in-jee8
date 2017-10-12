package de.gedoplan.whatsnewinjee8.cdi.event;

import javax.annotation.Priority;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;
import javax.enterprise.event.ObservesAsync;
import javax.inject.Inject;
import javax.interceptor.Interceptor;

import org.apache.commons.logging.Log;

@ApplicationScoped
public class EventObserver {

  @Inject
  Log log;

  void a(@Observes @Priority(Interceptor.Priority.APPLICATION + 1) DemoEvent e) {
    track(e, "a");
    sleep(250);
    track(e, "A");
  }

  void b(@Observes @Priority(Interceptor.Priority.APPLICATION + 2) DemoEvent e) {
    track(e, "b");
    sleep(80);
    track(e, "B");
  }

  void c(@Observes @Priority(Interceptor.Priority.APPLICATION + 3) DemoEvent e) {
    track(e, "c");
    sleep(120);
    track(e, "C");
  }

  void x(@ObservesAsync DemoEvent e) {
    track(e, "x");
    sleep(250);
    track(e, "X");
  }

  void y(@ObservesAsync DemoEvent e) {
    track(e, "y");
    sleep(80);
    if (e != null) {
      throw new RuntimeException("!Y");
    }
    track(e, "Y");
  }

  void z(@ObservesAsync DemoEvent e) {
    track(e, "z");
    sleep(120);
    if (e != null) {
      throw new RuntimeException("!Z");
    }
    track(e, "Z");
  }

  private void track(DemoEvent e, String s) {
    this.log.debug(s);
    e.add(s);
  }

  private static void sleep(int millis) {
    try {
      Thread.sleep(millis);
    } catch (InterruptedException e) {
    }

  }
}
