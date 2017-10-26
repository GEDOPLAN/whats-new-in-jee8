package de.gedoplan.whatsnewinjee8.persistence;

import de.gedoplan.baselibs.persistence.repository.SingleIdEntityRepository;
import de.gedoplan.whatsnewinjee8.entity.Country;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;

@ApplicationScoped
@Transactional(rollbackOn = Exception.class)
public class CountryRepository extends SingleIdEntityRepository<String, Country> {

}
