package de.gedoplan.whatsnewinjee8.validation.presentation;

import de.gedoplan.whatsnewinjee8.entity.Questionnaire;
import java.io.Serializable;
import java.time.ZonedDateTime;
import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;


import javax.inject.Inject;
import javax.inject.Named;
import javax.validation.Validator;

@Named
@SessionScoped
public class QuestionnairePresenter implements Serializable {
  @Inject
  Validator validator;

  private Questionnaire questionnaire;
  
  @PostConstruct
  void postConstruct() {
      questionnaire = new Questionnaire();
      questionnaire.setPollDate(ZonedDateTime.now());
      questionnaire.setName("Donald Duck");
      questionnaire.setAge(37);
      questionnaire.setComment("Bean Validation rocks!");
  }

  public Questionnaire getQuestionnaire() {
    return this.questionnaire;
  }
}
