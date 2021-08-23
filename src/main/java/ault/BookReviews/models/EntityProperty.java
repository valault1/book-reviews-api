package ault.BookReviews.models;

import java.util.ArrayList;
import lombok.Data;
import lombok.NoArgsConstructor;

import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
@NoArgsConstructor
public class EntityProperty {
  
  private String propertyName;

  private String propertyType;

  private String value;

  private enum PropertyType {
    STRING,
    REFERENCE,
    ARRAY,
  }

  public EntityProperty(EntitySchemaProperty prop, String value) {
    this.propertyName = prop.getPropertyName();
    this.propertyType = prop.getPropertyType();
    this.value = value;
  }

  



}