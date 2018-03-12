package de.gedoplan.whatsnewinjee8.entity;

import de.gedoplan.baselibs.persistence.entity.SingleIdEntity;

import java.time.LocalDate;

import javax.json.bind.annotation.JsonbNillable;
import javax.json.bind.annotation.JsonbTransient;
import javax.json.bind.annotation.JsonbTypeAdapter;
import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlTransient;

import lombok.Getter;
import lombok.Setter;

@Entity
@Access(AccessType.FIELD)
@Getter
@Setter
@JsonbNillable
public class Country extends SingleIdEntity<String> {

  @Id
  @Column(columnDefinition = "CHAR(2)")
  private String id;

  private String name;

  @Column(name = "PHONE_PREFIX", length = 5)
  private String phonePrefix;

  @Column(name = "CAR_CODE", length = 3)
  private String carCode;

  private long population;

  @JsonbTypeAdapter(ContinentConverter.class)
  @Convert(converter = ContinentConverter.class)
  private Continent continent;

  private LocalDate founded;

  private boolean expired;

  @Transient
  @JsonbTransient
  @XmlTransient
  private String dummy = "unused";

  public Country() {
  }

  public Country(String id, String name, String phonePrefix, String carCode, long population, Continent continent, LocalDate founded, boolean expired) {
    this.id = id;
    this.name = name;
    this.phonePrefix = phonePrefix;
    this.carCode = carCode;
    this.population = population;
    this.continent = continent;
    this.founded = founded;
    this.expired = expired;
  }

  public Country(Country other) {
    this.id = other.id;
    this.name = other.name;
    this.phonePrefix = other.phonePrefix;
    this.carCode = other.carCode;
    this.population = other.population;
    this.continent = other.continent;
    this.founded = other.founded;
    this.expired = other.expired;
  }

  // Bug in Yasson 1.0: Static fields get serialized. Moved to class Countries as workaround
  // public static Country CA = new Country("CA", "Canada", "1", null, 34_482_779, Continent.NORTH_AMERICA, LocalDate.of(1867, 7, 1), false);
  // public static Country CN = new Country("CN", "China", "86", null, 1_331_460_000, Continent.ASIA, LocalDate.of(1949, 10, 1), false);
  // public static Country DE = new Country("DE", "Germany", "49", "D", 81_879_976, Continent.EUROPE, LocalDate.of(1949, 9, 20), false);
  // public static Country IT = new Country("IT", "Italy", "39", "I", 60_221_210, Continent.EUROPE, LocalDate.of(1861, 3, 17), false);
  // public static Country US = new Country("US", "United States of America", "1", null, 305_548_183, Continent.NORTH_AMERICA, LocalDate.of(1776, 7, 4), false);
  // public static Country VN = new Country("VN", "Vietnam", "84", null, 87_840_000, Continent.ASIA, LocalDate.of(1976, 7, 2), false);
  // public static Country YU = new Country("YU", "Yugoslavia", null, null, 0, Continent.EUROPE, LocalDate.of(1918, 12, 1), true);

}
