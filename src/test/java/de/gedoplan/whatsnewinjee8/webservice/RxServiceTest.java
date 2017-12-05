package de.gedoplan.whatsnewinjee8.webservice;

import de.gedoplan.whatsnewinjee8.TestBase;

import java.util.concurrent.CompletionStage;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class RxServiceTest extends TestBase {

  private static Client client;
  private static WebTarget baseTarget;

  private static Log log = LogFactory.getLog(RxServiceTest.class);

  @BeforeClass
  public static void beforeClass() {
    client = ClientBuilder.newClient();

    baseTarget = client.target("http://localhost:8080/whats-new-in-jee8/rest");
  }

  @AfterClass
  public static void afterClass() {
    client.close();
  }

  @Test
  public void testQuestionAnswer() throws Exception {
    log.debug("Calling planetearth service");

    CompletionStage<String> planetearthCompletionStage = baseTarget
        .path("planetearth")
        .request()
        .accept(MediaType.TEXT_PLAIN)
        .rx()
        .get(String.class)
        .thenApply(q -> {
          log.debug("Call of planetearth returns " + q);
          return q;
        })
        .exceptionally(e -> {
          log.debug("Call of planetearth throws " + e);
          return "the ultimate question of life, the universe, and everything";
        });

    log.debug("Calling deepthought service");

    CompletionStage<String> deepThoughtCompletionStage = baseTarget
        .path("deepthought")
        .request()
        .accept(MediaType.TEXT_PLAIN)
        .rx()
        .get(String.class)
        .thenApply(a -> {
          log.debug("Call of deepthought returns " + a);
          return a;
        })
        .exceptionally(e -> {
          log.debug("Call of deepthought throws " + e);
          return "unknown";
        });

    log.debug("Doing something in parallel to REST calls");

    String result = planetearthCompletionStage
        .thenCombine(deepThoughtCompletionStage, (q, a) -> "The answer to " + q + " is " + a)
        .toCompletableFuture()
        .get();

    log.debug(result);
  }
}
