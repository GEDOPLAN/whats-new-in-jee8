package de.gedoplan.whatsnewinjee8.json.bind;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

import javax.json.bind.config.PropertyVisibilityStrategy;

public interface JsonAccessType {
  public static class AllFieldsVisibilityStrategy implements PropertyVisibilityStrategy {
    @Override
    public boolean isVisible(Field field) {
      return true;
    }

    @Override
    public boolean isVisible(Method method) {
      // return true;
      return false;
    }
  }

  public static class AllPropertiesVisibilityStrategy implements PropertyVisibilityStrategy {
    @Override
    public boolean isVisible(Field field) {
      return false;
    }

    @Override
    public boolean isVisible(Method method) {
      return true;
    }
  }
}
