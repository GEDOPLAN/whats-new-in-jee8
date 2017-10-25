package de.gedoplan.whatsnewinjee8.jsf;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

@FacesConverter(forClass = ZonedDateTime.class)
public class ZonedDateTimeConverter implements Converter<ZonedDateTime> {

    @Override
    public ZonedDateTime getAsObject(FacesContext context, UIComponent component, String value) {
        try {
            return value == null ? null : ZonedDateTime.parse(value, DateTimeFormatter.ISO_ZONED_DATE_TIME);
        } catch (Exception e) {
            throw new ConverterException(e);
        }
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, ZonedDateTime value) {
        return value == null ? null : value.format(DateTimeFormatter.ISO_ZONED_DATE_TIME);
    }

}
