package de.gedoplan.whatsnewinjee8.entity;

import javax.json.bind.adapter.JsonbAdapter;
import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter
public class ContinentConverter implements AttributeConverter<Continent, String>, JsonbAdapter<Continent, String> {

  private String encode(Continent attribute) {
    return attribute == null ? null : attribute.getIsoCode();
  }

  private Continent decode(String json) {
    return json == null ? null : Continent.forIsoCode(json);
  }

  @Override
  public String convertToDatabaseColumn(Continent attribute) {
    return encode(attribute);
  }

  @Override
  public Continent convertToEntityAttribute(String dbData) {
    return decode(dbData);
  }

  @Override
  public String adaptToJson(Continent obj) throws Exception {
    return encode(obj);
  }

  @Override
  public Continent adaptFromJson(String obj) throws Exception {
    return decode(obj);
  }

}
