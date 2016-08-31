package io.pivotal.security.entity;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "ValueSecret")
@DiscriminatorValue("value")
public class NamedValueSecret extends NamedStringSecret<NamedValueSecret> {

  public NamedValueSecret() {
  }

  public NamedValueSecret(String name) {
    super(name);
  }

  @Override
  public String getSecretType() {
    return "value";
  }
}