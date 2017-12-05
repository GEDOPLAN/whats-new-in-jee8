package de.gedoplan.whatsnewinjee8.webservice;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("deepthought")
public class DeepThoughtResource {

  @GET
  @Produces(MediaType.TEXT_PLAIN)
  public String getAnswer() throws Exception {
    Thread.sleep(7500);
    return "42";
  }
}
