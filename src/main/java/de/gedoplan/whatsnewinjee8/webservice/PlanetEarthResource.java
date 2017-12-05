package de.gedoplan.whatsnewinjee8.webservice;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("planetearth")
public class PlanetEarthResource {

  @GET
  @Produces(MediaType.TEXT_PLAIN)
  public String getQuestion() throws Exception {
    Thread.sleep(10000);
    throw new RuntimeException("blown up");
  }
}
