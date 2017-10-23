package de.gedoplan.whatsnewinjee8.entity;

import java.util.HashMap;
import java.util.Map;

public enum Continent {
  AFRICA("AF"), ANTARCTICA("AN"), ASIA("AS"), AUSTRALIA("OC"), EUROPE("EU"), NORTH_AMERICA("NA"), SOUTH_AMERICA("SA");

  /*
   * The ISO code here is included for the demonstration of converters only. The standard mapping of enums
   * with the help of @Enumerated works out-of-the-box for simple enumerations without additional attributes.
   */
  private String isoCode;
  private static Map<String, Continent> isoMap = new HashMap<>();
  static {
    for (Continent continent : Continent.values()) {
      isoMap.put(continent.getIsoCode(), continent);
    }
  }

  private Continent(String isoCode) {
    this.isoCode = isoCode;
  }

  public String getIsoCode() {
    return this.isoCode;
  }

  public static Continent forIsoCode(String isoCode) {
    Continent continent = isoMap.get(isoCode);
    if (continent != null) {
      return continent;
    }

    throw new IllegalArgumentException("Unknown continent code: " + isoCode);
  }
}
