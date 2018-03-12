package de.gedoplan.whatsnewinjee8.cdi.event;

import de.gedoplan.whatsnewinjee8.entity.Countries;
import de.gedoplan.whatsnewinjee8.persistence.CountryRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.Dependent;
import javax.enterprise.context.Initialized;
import javax.enterprise.event.Observes;
import javax.inject.Inject;
import javax.servlet.ServletContext;
import javax.transaction.Transactional;

@Dependent
public class InitCountryDemoDataService {

  @Inject
  CountryRepository countryRepository;

  @Transactional(rollbackOn = Exception.class)
  void createDemoData(@Observes @Initialized(ApplicationScoped.class) ServletContext event) {
    if (this.countryRepository.countAll() == 0) {
      this.countryRepository.merge(Countries.CA);
      this.countryRepository.merge(Countries.CN);
      this.countryRepository.merge(Countries.DE);
      this.countryRepository.merge(Countries.IT);
      this.countryRepository.merge(Countries.US);
      this.countryRepository.merge(Countries.VN);
      this.countryRepository.merge(Countries.YU);
    }
  }
}
