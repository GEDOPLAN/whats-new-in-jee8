package de.gedoplan.whatsnewinjee8.json.bind;

import de.gedoplan.whatsnewinjee8.entity.Continent;
import de.gedoplan.whatsnewinjee8.entity.Country;
import java.time.LocalDate;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.logging.Log;

@Named
@RequestScoped
@Getter
@Setter
public class JsonbPresenter {
    private Country country = new Country(Country.DE);
    private String json;
    
    @Inject Log log;
    
    public void toJson() {
            try (Jsonb jsonb = JsonbBuilder.create()) {
            json = jsonb.toJson(country);
            }
            catch (Exception e) {
                log.error("Cannot convert to JSON", e);
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, e.toString(), e.toString()));
            }
    }
    
    public void fromJson() {
            try (Jsonb jsonb = JsonbBuilder.create()) {
                country = jsonb.fromJson(json, Country.class);
            }
            catch (Exception e) {
                log.error("Cannot deserialize JSON", e);
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, e.toString(), e.toString()));
            }
    }
    
    public Continent[] getContinents() {
        return Continent.values();
    }
}
