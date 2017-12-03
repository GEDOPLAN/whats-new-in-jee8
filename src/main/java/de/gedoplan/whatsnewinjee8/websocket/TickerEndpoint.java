package de.gedoplan.whatsnewinjee8.websocket;

import java.util.Random;

import javax.ejb.Schedule;
import javax.ejb.Stateless;
import javax.faces.push.Push;
import javax.faces.push.PushContext;
import javax.inject.Inject;

import org.apache.commons.logging.Log;

@Stateless
public class TickerEndpoint {
  private static final String[] coolStuff = { "JSON Binding", "Websocket integration", "Java 8 alignment", "CDI SE support", "CDI observer ordering", "Asynchronuous CDI events",
      "New BV constraints" };

  private static final Random random = new Random();

  @Inject
  private Log log;

  @Inject
  @Push(channel = "ticker")
  private PushContext channel;

  @Schedule(second = "*/2", minute = "*", hour = "*", persistent = false)
  public void tick() {
    String message = coolStuff[random.nextInt(coolStuff.length)];
    this.log.debug("Send \"" + message + "\"");
    this.channel.send(message);
  }
}
