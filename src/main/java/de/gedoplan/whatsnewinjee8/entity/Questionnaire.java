package de.gedoplan.whatsnewinjee8.entity;

import de.gedoplan.whatsnewinjee8.validation.group.InitialInput;

import java.io.Serializable;
import java.time.ZonedDateTime;
import java.util.Arrays;
import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;
import javax.validation.groups.Default;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Questionnaire implements Serializable {

  @NotNull(groups = { InitialInput.class, Default.class })
  @PastOrPresent(groups = { InitialInput.class, Default.class })
  private ZonedDateTime pollDate;

  @NotBlank(groups = { InitialInput.class, Default.class })
  private String name;

  @Valid
  private Address address = new Address();

  @Min(value = 18, groups = { InitialInput.class, Default.class })
  @Max(value = 120, groups = { InitialInput.class, Default.class })
  private int age;

  @Email(groups = { InitialInput.class, Default.class })
  // @Pattern(regexp = "[^@]+@[^@]+\\.[^@]+", groups = { InitialInput.class, Default.class })
  private String email;

  @NotNull
  @Size(min = 10, max = 140, groups = { InitialInput.class, Default.class })
  private String comment;

  private List<@Positive @Max(6) Integer> marks;

  public void setMarks(Integer... marks) {
    this.marks = Arrays.asList(marks);
  }

  @AssertTrue(groups = { InitialInput.class, Default.class }, message = "Personen unter 80 müssen eine EMail-Adresse haben")
  public boolean isValid() {
    if (this.age < 80) {
      return this.email != null;
    }
    return true;
  }
}
