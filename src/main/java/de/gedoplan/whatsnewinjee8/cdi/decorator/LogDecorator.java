package de.gedoplan.whatsnewinjee8.cdi.decorator;

import javax.annotation.Priority;
import javax.decorator.Decorator;
import javax.decorator.Delegate;
import javax.inject.Inject;

import org.apache.commons.logging.Log;

@Decorator
@Priority(1)
public abstract class LogDecorator implements Log {
  @Inject
  @Delegate
  Log delegate;

  @Override
  public void info(Object arg0) {
    this.delegate.info(arg0 + " [Decorated!]");
  }

}
