package de.gedoplan.whatsnewinjee8.jpa;

import de.gedoplan.whatsnewinjee8.TestBase;

import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.Supplier;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;

/**
 * Basisklasse für JPA-Tests.
 *
 * Diese Klasse hält eine einmalig initialisierte EntityManagerFactory für alle Tests bereit. Zusätzlich wird vor jedem Test ein
 * EntityManager erstellt und eine Transaktion gestartet. Die Transaktion wird nach jedem Test wieder beendet und der
 * EntityManager geschlossen.
 *
 * @author dw
 *
 */
public abstract class JpaTestBase extends TestBase {
  protected static EntityManagerFactory entityManagerFactory;
  protected EntityManager entityManager;

  protected Log log = LogFactory.getLog(getClass());

  /**
   * Test-Vorbereitung: EntityManagerFactory erstellen.
   */
  @BeforeClass
  public static void beforeClass() {
    if (entityManagerFactory == null) {
      entityManagerFactory = Persistence.createEntityManagerFactory("conference-se");
    }
  }

  /**
   * Test-Vorbereitung: EntityManager öffnen und Transaktion starten.
   */
  @Before
  public void before() {
    this.log.trace("create entitymanager and start transaction");
    this.entityManager = entityManagerFactory.createEntityManager();
    this.entityManager.getTransaction().begin();
  }

  /**
   * Test-Nachbereitung: Transaktion beenden und EntityManager schliessen.
   */
  @After
  public void after() {
    try {
      EntityTransaction transaction = this.entityManager.getTransaction();
      if (transaction.isActive()) {
        if (!transaction.getRollbackOnly()) {
          this.log.trace("commit transaction");
          transaction.commit();
        } else {
          this.log.trace("rollback transaction");
          transaction.rollback();
        }
      }
    } finally {
      try {
        this.log.trace("close entitymanager");
        this.entityManager.close();
      } catch (Exception e) // CHECKSTYLE:IGNORE
      {
        // ignore
      }
    }
  }

  /**
   * Run test method ignoring exceptions.
   *
   * @param testCreator
   *          Supplier for test class object (derived from TestBase)
   * @param testMethod
   *          Test method reference
   */
  protected static <T extends JpaTestBase> void runIgnoringException(Supplier<T> testCreator, Consumer<T> testMethod) {
    runIgnoringException(testCreator, testMethod, x -> true);
  }

  /**
   * Run test method, if condition is met, ignoring exceptions.
   *
   * @param testCreator
   *          Supplier for test class object (derived from TestBase)
   * @param testMethod
   *          Test method
   * @param condition
   *          Condition for calling test method
   */
  @SuppressWarnings("static-access")
  protected static <T extends JpaTestBase> void runIgnoringException(Supplier<T> testCreator, Consumer<T> testMethod, Predicate<T> condition) {
    try {
      T test = testCreator.get();
      test.beforeClass();
      test.before();
      if (condition.test(test)) {
        testMethod.accept(test);
      }
      test.after();
    } catch (Exception e) {
      // ignore
    }
  }
}
