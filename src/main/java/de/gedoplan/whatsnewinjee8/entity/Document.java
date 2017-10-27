package de.gedoplan.whatsnewinjee8.entity;

import de.gedoplan.baselibs.persistence.entity.GeneratedIntegerIdEntity;

import java.util.Date;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Getter;
import lombok.Setter;

@Entity
@Access(AccessType.FIELD)
@Getter
@Setter
public class Document extends GeneratedIntegerIdEntity {

  private String text;

  @Temporal(TemporalType.TIMESTAMP)
  private Date lastChange;

  public Document(String text) {
    this.text = text;
  }

  protected Document() {
  }

  @PrePersist
  @PreUpdate
  private void fillLastChange() {
    this.lastChange = new Date();
  }

}
