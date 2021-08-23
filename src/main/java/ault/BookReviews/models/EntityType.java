package ault.BookReviews.models;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

import org.json.simple.JSONObject;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
@NoArgsConstructor
public class EntityType {

  @Id
  private String id;

  private String entityTypeName;

  private List<EntitySchemaProperty> properties;

  private boolean isTaggable;

  public EntityType(String name, List<EntitySchemaProperty> properties, boolean isTaggable) {
    this.entityTypeName = name;
    this.properties = properties;
    this.isTaggable = isTaggable;
  }

  public EntityType(String id, String name, boolean isTaggable, List<EntitySchemaProperty> properties) {
    this.id= id;
    this.entityTypeName = name;
    this.properties = properties;
    this.isTaggable = isTaggable;
  }

}