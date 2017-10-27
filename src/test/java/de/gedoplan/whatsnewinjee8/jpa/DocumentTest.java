package de.gedoplan.whatsnewinjee8.jpa;

import static org.junit.Assert.*;

import de.gedoplan.whatsnewinjee8.cdi.CdiTestBase;
import de.gedoplan.whatsnewinjee8.entity.Document;
import de.gedoplan.whatsnewinjee8.persistence.DocumentRepository;

import javax.inject.Inject;

import org.apache.commons.logging.Log;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

/**
 * Test der Persistence-Fuktionalität bzgl. der Entity Country.
 *
 * @author dw
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class DocumentTest extends CdiTestBase {

  @Inject
  Log log;

  @Inject
  DocumentRepository documentRepository;

  @Test
  public void test_00_clearData() {
    this.log.info("----- test_00_clearData -----");

    this.documentRepository.removeAll();
  }

  @Test
  public void test_01_insertData() throws Exception {
    this.log.info("----- test_01_insertData -----");

    for (int i = 1; i < 10; ++i) {
      Document document = new Document("Text " + i);
      this.documentRepository.persist(document);

      this.log.debug("Inserted: " + document);
    }

    this.documentRepository
        .findAll()
        .forEach(d -> assertNotNull("Document.lastChange must not be null", d.getLastChange()));
  }

}
