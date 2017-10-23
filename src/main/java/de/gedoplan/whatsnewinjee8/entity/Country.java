package de.gedoplan.whatsnewinjee8.entity;

import de.gedoplan.baselibs.persistence.entity.SingleIdEntity;
import de.gedoplan.whatsnewinjee8.json.bind.JsonAccessType;

import java.time.LocalDate;

import javax.json.bind.annotation.JsonbNillable;
import javax.json.bind.annotation.JsonbTransient;
import javax.json.bind.annotation.JsonbTypeAdapter;
import javax.json.bind.annotation.JsonbVisibility;
import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Getter;

@Entity
@Access(AccessType.FIELD)
@Getter
// @Setter
@JsonbVisibility(JsonAccessType.AllFieldsVisibilityStrategy.class)
@JsonbNillable
public class Country extends SingleIdEntity<String> {
  @Id
  @Column(name = "ISO_CODE", length = 2)
  private String isoCode;

  private String name;

  @Column(name = "PHONE_PREFIX", length = 5)
  private String phonePrefix;

  @Column(name = "CAR_CODE", length = 3)
  private String carCode;

  private long population;

  @JsonbTypeAdapter(ContinentJsonbAdapter.class)
  private Continent continent;

  private LocalDate founded;

  private boolean expired;

  @JsonbTransient
  private String dummy = "not serialized";

  // TODO protected sollte möglich sein
  protected Country() {
  }

  @JsonbTransient
  @Override
  public String getId() {
    return this.isoCode;
  }

  public Country(String isoCode, String name, String phonePrefix, String carCode, long population, Continent continent, LocalDate founded, boolean expired) {
    this.isoCode = isoCode;
    this.name = name;
    this.phonePrefix = phonePrefix;
    this.carCode = carCode;
    this.population = population;
    this.continent = continent;
    this.founded = founded;
    this.expired = expired;
  }

  public static Country CA = new Country("CA", "Canada", "1", null, 34_482_779, Continent.NORTH_AMERICA, LocalDate.of(1867, 7, 1), false);
  public static Country CN = new Country("CN", "China", "86", null, 1_331_460_000, Continent.ASIA, LocalDate.of(1949, 10, 1), false);
  public static Country DE = new Country("DE", "Germany", "49", "D", 81_879_976, Continent.EUROPE, LocalDate.of(1949, 9, 20), false);
  public static Country IT = new Country("IT", "Italy", "39", "I", 60_221_210, Continent.EUROPE, LocalDate.of(1861, 3, 17), false);
  public static Country US = new Country("US", "United States of America", "1", null, 305_548_183, Continent.NORTH_AMERICA, LocalDate.of(1776, 7, 4), false);
  public static Country VN = new Country("VN", "Vietnam", "84", null, 87_840_000, Continent.ASIA, LocalDate.of(1976, 7, 2), false);
  public static Country YU = new Country("YU", "Yugoslavia", null, null, 0, Continent.EUROPE, LocalDate.of(1918, 12, 1), true);

}
