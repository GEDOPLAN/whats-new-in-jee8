package de.gedoplan.whatsnewinjee8.json.bind;

import static org.junit.Assert.*;
import static org.unitils.reflectionassert.ReflectionAssert.*;

import de.gedoplan.whatsnewinjee8.entity.Country;

import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;

public class JsonBindingTest {

  static final Country TEST_COUNTRY = Country.CA;
  static final String TEST_JSON = "{\"carCode\":null,\"continent\":\"NA\",\"expired\":false,\"founded\":\"1867-07-01\",\"id\":\"CA\",\"name\":\"Canada\",\"phonePrefix\":\"1\",\"population\":34482779}";

  static final Log log = LogFactory.getLog(JsonBindingTest.class);

  @Test
  public void test_01_testToJson() throws Exception {
    Jsonb jsonb = JsonbBuilder.create();

    String json = jsonb.toJson(TEST_COUNTRY);

    log.debug("JSON string: " + json);

    assertEquals(TEST_JSON, json);

  }

  @Test
  public void test_02_testFromJson() throws Exception {
    Jsonb jsonb = JsonbBuilder.create();

    Country country = jsonb.fromJson(TEST_JSON, Country.class);

    log.debug("Object: " + country);

    assertReflectionEquals(TEST_COUNTRY, country);
  }
}
