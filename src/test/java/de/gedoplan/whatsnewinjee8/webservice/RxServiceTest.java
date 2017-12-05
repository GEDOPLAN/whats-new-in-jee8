package de.gedoplan.whatsnewinjee8.webservice;

import java.util.concurrent.CompletionStage;

import javax.ws.rs.core.MediaType;

import org.junit.Test;

public class RxServiceTest extends RestTestBase {

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
