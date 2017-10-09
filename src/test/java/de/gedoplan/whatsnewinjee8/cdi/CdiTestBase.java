package de.gedoplan.whatsnewinjee8.cdi;

import javax.enterprise.context.spi.CreationalContext;
import javax.enterprise.inject.se.SeContainer;
import javax.enterprise.inject.se.SeContainerInitializer;
import javax.enterprise.inject.spi.AnnotatedType;
import javax.enterprise.inject.spi.BeanManager;
import javax.enterprise.inject.spi.InjectionTarget;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;

public abstract class CdiTestBase {

  protected static SeContainer container;

  @BeforeClass
  public static void beforeClass() {
    container = SeContainerInitializer.newInstance().initialize();
  }

  @Before
  @SuppressWarnings({ "rawtypes", "unchecked" })
  public void before() {
    BeanManager beanManager = container.getBeanManager();

    CreationalContext creationalContext = beanManager.createCreationalContext(null);

    AnnotatedType annotatedType = beanManager.createAnnotatedType(this.getClass());
    InjectionTarget injectionTarget = beanManager.createInjectionTarget(annotatedType);
    injectionTarget.inject(this, creationalContext);
  }

  @AfterClass
  public static void afterClass() {
    container.close();
  }

}
