package de.gedoplan.whatsnewinjee8.jsf;

import de.gedoplan.whatsnewinjee8.entity.Country;
import de.gedoplan.whatsnewinjee8.persistence.CountryRepository;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import lombok.Getter;
import lombok.Setter;

@Named
@RequestScoped
public class CountryPresenter implements Serializable {

  @Inject
  CountryRepository countryRepository;

  @Getter
  private List<Country> countries;

  @PostConstruct
  void postConstruct() {
    this.countries = this.countryRepository.findAll();
  }

  @Getter
  @Setter
  private Country someCountry;
}
