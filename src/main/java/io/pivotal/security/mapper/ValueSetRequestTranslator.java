package io.pivotal.security.mapper;

import com.jayway.jsonpath.DocumentContext;
import io.pivotal.security.entity.NamedValueSecret;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import javax.validation.ValidationException;

@Component
public class ValueSetRequestTranslator implements RequestTranslator<NamedValueSecret> {

  @Override
  public NamedValueSecret makeEntity(String name) {
    return new NamedValueSecret(name);
  }

  @Override
  public NamedValueSecret populateEntityFromJson(NamedValueSecret namedStringSecret, DocumentContext documentContext) {
    String value = documentContext.read("$.value");
    if (StringUtils.isEmpty(value)) {
      throw new ValidationException("error.missing_string_secret_value");
    }
    namedStringSecret.setValue(value);
    return namedStringSecret;
  }
}