package ault.BookReviews.models;

import java.util.ArrayList;
import lombok.Data;
import lombok.NoArgsConstructor;

import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
@NoArgsConstructor
public class EntitySchemaProperty {
  
  private String propertyName;

  private boolean isOptional;

  private String propertyType;

  private enum PropertyType {
    STRING,
    REFERENCE,
    ARRAY,
  }

  public EntitySchemaProperty(String propertyName, boolean isOptional, String propertyType) {
    this.propertyName = propertyName;
    this.isOptional = isOptional;
    this.propertyType = propertyType;
  }

  



}