package de.gedoplan.whatsnewinjee8.entity;

import javax.json.bind.adapter.JsonbAdapter;

public class ContinentJsonbAdapter implements JsonbAdapter<Continent, String> {

  @Override
  public String adaptToJson(Continent attribute) throws Exception {
    return attribute == null ? null : attribute.getIsoCode();
  }

  @Override
  public Continent adaptFromJson(String json) throws Exception {
    return json == null ? null : Continent.forIsoCode(json);
  }

}
