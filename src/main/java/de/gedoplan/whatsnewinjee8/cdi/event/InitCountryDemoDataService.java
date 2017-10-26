package de.gedoplan.whatsnewinjee8.cdi.event;

import de.gedoplan.whatsnewinjee8.entity.Country;
import de.gedoplan.whatsnewinjee8.persistence.CountryRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.Dependent;
import javax.enterprise.context.Initialized;
import javax.enterprise.event.Observes;
import javax.inject.Inject;
import javax.transaction.Transactional;

@Dependent
public class InitCountryDemoDataService {

  @Inject
  CountryRepository countryRepository;

  @Transactional(rollbackOn = Exception.class)
  void createDemoData(@Observes @Initialized(ApplicationScoped.class) Object event) {
    if (this.countryRepository.countAll() == 0) {
      this.countryRepository.merge(Country.CA);
      this.countryRepository.merge(Country.CN);
      this.countryRepository.merge(Country.DE);
      this.countryRepository.merge(Country.IT);
      this.countryRepository.merge(Country.US);
      this.countryRepository.merge(Country.VN);
      this.countryRepository.merge(Country.YU);
    }
  }
}
