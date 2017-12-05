package de.gedoplan.whatsnewinjee8.json.bind;

import de.gedoplan.whatsnewinjee8.entity.Country;
import de.gedoplan.whatsnewinjee8.persistence.CountryRepository;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@ApplicationScoped
@Path("country")
public class CountryResource {

  @Inject
  CountryRepository countryRepository;

  @GET
  @Produces(MediaType.APPLICATION_JSON)
  public List<Country> getAll() {
    return this.countryRepository.findAll();
  }
}
