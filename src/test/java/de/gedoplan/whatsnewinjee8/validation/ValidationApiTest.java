package de.gedoplan.whatsnewinjee8.validation;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import de.gedoplan.whatsnewinjee8.TestBase;
import de.gedoplan.whatsnewinjee8.entity.Questionnaire;

import java.time.ZonedDateTime;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import de.gedoplan.whatsnewinjee8.validation.group.InitialInput;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ValidationApiTest extends TestBase {
  private static ValidatorFactory validatorFactory;
  private Validator validator;

  @BeforeClass
  public static void beforeClass() {
    validatorFactory = Validation.buildDefaultValidatorFactory();
  }

  @Before
  public void before() {
    this.validator = validatorFactory.getValidator();
  }

  @Test
  public void test_01_Correct() throws Exception {
    System.out.println("----- test_01_Correct -----");

    Questionnaire questionnaire = new Questionnaire();
    questionnaire.setName("Erika Mustermann");
    questionnaire.setAge(42);
    questionnaire.setEmail("em@mail.de");
    questionnaire.setComment("Bean Validation ist prima!");
    questionnaire.setPollDate(ZonedDateTime.now());
    questionnaire.setMarks(2, 4, 3);

    Set<ConstraintViolation<Questionnaire>> constraintViolations = this.validator.validate(questionnaire);
    for (ConstraintViolation<Questionnaire> constraintViolation : constraintViolations) {
      System.out.println(constraintViolation.getPropertyPath() + " " + constraintViolation.getMessage());
    }

    assertThat("Anzahl Regelverletzungen", constraintViolations.size(), is(0));
  }

  @Test
  public void test_02_Invalid() throws Exception {
    System.out.println("----- test_02_Invalid -----");

    Questionnaire questionnaire = new Questionnaire();
    questionnaire.setName("Max Mustermann");
    questionnaire.setAge(44);
    questionnaire.setEmail("mm");
    questionnaire.getAddress().setZipCode("00000");
    questionnaire.getAddress().setCity("DaUndDort");
    questionnaire.getAddress().setStreet("Nirgendwoweg 1");
    questionnaire.setMarks(2, 0, 3);

    Set<ConstraintViolation<Questionnaire>> constraintViolations = this.validator.validate(questionnaire);
    for (ConstraintViolation<Questionnaire> constraintViolation : constraintViolations) {
      System.out.println(constraintViolation.getPropertyPath() + " " + constraintViolation.getMessage());
    }

    assertThat("Anzahl Regelverletzungen", constraintViolations.size(), is(5));
  }

  @Test
  public void test_03_Invalid_InitialInput() throws Exception {
    System.out.println("----- test_03_Invalid_InitialInput -----");

    Questionnaire questionnaire = new Questionnaire();
    questionnaire.setName("Max Mustermann");
    questionnaire.setAge(44);
    questionnaire.setEmail("mm");

    Set<ConstraintViolation<Questionnaire>> constraintViolations = this.validator.validate(questionnaire, InitialInput.class);
    for (ConstraintViolation<Questionnaire> constraintViolation : constraintViolations) {
      System.out.println(constraintViolation.getPropertyPath() + " " + constraintViolation.getMessage());
    }

    assertThat("Anzahl Regelverletzungen", constraintViolations.size(), is(2));
  }
}
