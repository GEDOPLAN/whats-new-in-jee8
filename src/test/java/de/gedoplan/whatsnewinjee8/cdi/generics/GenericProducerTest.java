package de.gedoplan.whatsnewinjee8.cdi.generics;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

import de.gedoplan.whatsnewinjee8.cdi.CdiTestBase;

import java.util.List;

import javax.inject.Inject;

import org.apache.commons.logging.Log;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class GenericProducerTest extends CdiTestBase {

  @Inject
  List<String> stringList;

  @Inject
  List<Integer> integerList;

  @Inject
  Log log;

  @Test
  public void test_01_testStringList() throws Exception {
    this.stringList.forEach(this.log::debug);

    assertThat(this.stringList, contains("Ene", "mene", "Muh"));
  }

  @Test
  public void test_02_testIntegerList() throws Exception {
    this.integerList.forEach(this.log::debug);

    assertThat(this.integerList, contains(1, 2, 3));
  }
}
