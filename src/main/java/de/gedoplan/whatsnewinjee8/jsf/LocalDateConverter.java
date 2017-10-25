package de.gedoplan.whatsnewinjee8.jsf;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@FacesConverter(forClass = LocalDate.class)
public class LocalDateConverter implements Converter<LocalDate>{

    @Override
    public LocalDate getAsObject(FacesContext context, UIComponent component, String value) {
        return value == null ? null : LocalDate.parse(value, DateTimeFormatter.ISO_DATE);
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, LocalDate value) {
        return value == null ? null : value.format(DateTimeFormatter.ISO_DATE);
    }
    
}
