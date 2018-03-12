package de.gedoplan.whatsnewinjee8.entity;

import java.time.LocalDate;

public class Countries {
  public static Country CA = new Country("CA", "Canada", "1", null, 34_482_779, Continent.NORTH_AMERICA, LocalDate.of(1867, 7, 1), false);
  public static Country CN = new Country("CN", "China", "86", null, 1_331_460_000, Continent.ASIA, LocalDate.of(1949, 10, 1), false);
  public static Country DE = new Country("DE", "Germany", "49", "D", 81_879_976, Continent.EUROPE, LocalDate.of(1949, 9, 20), false);
  public static Country IT = new Country("IT", "Italy", "39", "I", 60_221_210, Continent.EUROPE, LocalDate.of(1861, 3, 17), false);
  public static Country US = new Country("US", "United States of America", "1", null, 305_548_183, Continent.NORTH_AMERICA, LocalDate.of(1776, 7, 4), false);
  public static Country VN = new Country("VN", "Vietnam", "84", null, 87_840_000, Continent.ASIA, LocalDate.of(1976, 7, 2), false);
  public static Country YU = new Country("YU", "Yugoslavia", null, null, 0, Continent.EUROPE, LocalDate.of(1918, 12, 1), true);
}
