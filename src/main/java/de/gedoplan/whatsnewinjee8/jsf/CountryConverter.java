package de.gedoplan.whatsnewinjee8.jsf;

import de.gedoplan.whatsnewinjee8.entity.Country;
import de.gedoplan.whatsnewinjee8.persistence.CountryRepository;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;

@FacesConverter(forClass = Country.class, managed = true)
public class CountryConverter implements Converter<Country> {
  @Inject
  CountryRepository countryRepository;

  @Override
  public Country getAsObject(FacesContext facesContext, UIComponent uiComponent, String uiValue) {
    if (uiValue == null) {
      return null;
    }

    // Workaround if "managed=true" does not work (e. g. in GLF 5.0)
    // if (this.countryRepository == null) {
    // this.countryRepository = CDI.current().select(CountryRepository.class).get();
    // }

    try {
      Country country = this.countryRepository.findById(uiValue);
      if (country != null) {
        return country;
      }

      throw new IllegalArgumentException("Illegal ui value: " + uiValue);
    } catch (Exception e) {
      FacesMessage msg = new FacesMessage(e.toString());
      msg.setSeverity(FacesMessage.SEVERITY_ERROR);
      throw new ConverterException(msg);
    }
  }

  @Override
  public String getAsString(FacesContext facesContext, UIComponent uiComponent, Country beanValue) {
    if (beanValue == null) {
      return null;
    }

    return beanValue.getId().toString();
  }

}
