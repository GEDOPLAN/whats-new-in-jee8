package de.gedoplan.whatsnewinjee8.cdi;

import de.gedoplan.whatsnewinjee8.TestBase;

import javax.enterprise.context.spi.CreationalContext;
import javax.enterprise.inject.se.SeContainer;
import javax.enterprise.inject.se.SeContainerInitializer;
import javax.enterprise.inject.spi.AnnotatedType;
import javax.enterprise.inject.spi.BeanManager;
import javax.enterprise.inject.spi.InjectionTarget;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;

public abstract class CdiTestBase extends TestBase {

  protected static SeContainer container;

  @BeforeClass
  public static void startCdiContainer() {
    container = SeContainerInitializer.newInstance().initialize();
  }

  @Before
  @SuppressWarnings({ "rawtypes", "unchecked" })
  public void handleInjectsInTestClass() {
    BeanManager beanManager = container.getBeanManager();

    CreationalContext creationalContext = beanManager.createCreationalContext(null);

    AnnotatedType annotatedType = beanManager.createAnnotatedType(this.getClass());
    InjectionTarget injectionTarget = beanManager.createInjectionTarget(annotatedType);
    injectionTarget.inject(this, creationalContext);
  }

  @AfterClass
  public static void stopCdiContainer() {
    if (container != null) {
      container.close();
    }
  }

}
