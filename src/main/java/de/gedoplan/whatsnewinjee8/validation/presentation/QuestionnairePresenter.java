package de.gedoplan.whatsnewinjee8.validation.presentation;

import de.gedoplan.whatsnewinjee8.entity.Questionnaire;

import java.io.Serializable;
import java.time.ZonedDateTime;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

@Named
@SessionScoped
public class QuestionnairePresenter implements Serializable {

  private Questionnaire questionnaire;

  @PostConstruct
  void postConstruct() {
    this.questionnaire = new Questionnaire();
    this.questionnaire.setPollDate(ZonedDateTime.now());
    this.questionnaire.setName("Donald Duck");
    this.questionnaire.setAge(37);
    this.questionnaire.setComment("Bean Validation rocks!");
  }

  public Questionnaire getQuestionnaire() {
    return this.questionnaire;
  }
}
