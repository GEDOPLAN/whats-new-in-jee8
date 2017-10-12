package de.gedoplan.whatsnewinjee8.cdi.event;

import java.util.concurrent.CompletionStage;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Event;
import javax.inject.Inject;

@ApplicationScoped
public class EventProducer {

  @Inject
  Event<DemoEvent> eventSource;

  public DemoEvent fireSyncEvent() {
    DemoEvent event = new DemoEvent();
    this.eventSource.fire(event);

    event.add("M");

    return event;
  }

  public DemoEvent fireAsyncEvent() {
    DemoEvent event = new DemoEvent();
    CompletionStage<DemoEvent> completionStage = this.eventSource.fireAsync(event);

    event.add("M");

    try {
      completionStage.toCompletableFuture().join();
    } catch (Exception e) {
      for (Throwable ex : e.getSuppressed()) {
        event.add(ex.getMessage());
      }
    }

    return event;
  }
}
