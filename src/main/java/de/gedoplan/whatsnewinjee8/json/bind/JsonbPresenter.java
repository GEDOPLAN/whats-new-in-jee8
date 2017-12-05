package de.gedoplan.whatsnewinjee8.json.bind;

import de.gedoplan.whatsnewinjee8.entity.Continent;
import de.gedoplan.whatsnewinjee8.entity.Country;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;
import javax.json.bind.JsonbConfig;

import org.apache.commons.logging.Log;

import lombok.Getter;
import lombok.Setter;

@Named
@RequestScoped
@Getter
@Setter
public class JsonbPresenter {
  private Country country = new Country(Country.DE);
  private String json;

  @Inject
  Log log;

  public void toJson() {
    JsonbConfig jsonbConfig = new JsonbConfig().withFormatting(true);
    try (Jsonb jsonb = JsonbBuilder.create(jsonbConfig)) {
      this.json = jsonb.toJson(this.country);
    } catch (Exception e) {
      this.log.error("Cannot convert to JSON", e);
      FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, e.toString(), e.toString()));
    }
  }

  public void fromJson() {
    try (Jsonb jsonb = JsonbBuilder.create()) {
      this.country = jsonb.fromJson(this.json, Country.class);
    } catch (Exception e) {
      this.log.error("Cannot deserialize JSON", e);
      FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, e.toString(), e.toString()));
    }
  }

  public Continent[] getContinents() {
    return Continent.values();
  }
}
