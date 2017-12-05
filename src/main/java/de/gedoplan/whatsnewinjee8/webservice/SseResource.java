package de.gedoplan.whatsnewinjee8.webservice;

import java.util.Date;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.ejb.Singleton;
import javax.ejb.Timeout;
import javax.ejb.TimerConfig;
import javax.ejb.TimerService;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.sse.Sse;
import javax.ws.rs.sse.SseBroadcaster;
import javax.ws.rs.sse.SseEventSink;

@Singleton
@Path("sse")
public class SseResource {
  @Context
  private Sse sse;

  private SseBroadcaster sseBroadcaster;

  @Resource
  private TimerService timerService;

  @PostConstruct
  public void init() {
    this.sseBroadcaster = this.sse.newBroadcaster();

    this.timerService.createIntervalTimer(0, 1000, new TimerConfig(null, false));
  }

  @Timeout
  public void tick() {
    this.sseBroadcaster.broadcast(this.sse.newEvent("Hello, it is " + new Date()));
  }

  @GET
  @Produces(MediaType.SERVER_SENT_EVENTS)
  public void register(@Context SseEventSink sseEventSink) {
    this.sseBroadcaster.register(sseEventSink);
  }

}
