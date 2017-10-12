package de.gedoplan.whatsnewinjee8.cdi.event;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public class DemoEvent {
  private Queue<String> log = new ConcurrentLinkedQueue<>();

  public void add(String s) {
    this.log.add(s);
  }

  public Queue<String> getLog() {
    return this.log;
  }
}
