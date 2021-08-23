package ault.BookReviews.models;

import java.util.List;
import lombok.Data;
import lombok.NoArgsConstructor;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
@NoArgsConstructor
public class Entity {

  @Id
  private String id;

  private String entityTypeId;

  private String name;

  private String notes;

  private List<String> tags;

  private List<EntityProperty> properties;

  public Entity(String entityTypeId, List<EntityProperty> properties, List<String> tags) {
    this.entityTypeId = entityTypeId;
    this.properties = properties;
    this.tags = tags;
  }

  public Entity(String entityTypeId, List<EntityProperty> properties, List<String> tags, String name) {
    this.entityTypeId = entityTypeId;
    this.properties = properties;
    this.tags = tags;
    this.name = name;
  }

  public Entity(String entityTypeId, List<EntityProperty> properties, List<String> tags, String name, String notes) {
    this.notes = notes;
    this.entityTypeId = entityTypeId;
    this.properties = properties;
    this.tags = tags;
    this.name = name;

  }

  public Entity(String id, String entityTypeId, List<EntityProperty> properties, List<String> tags, String name,
      String notes) {
    this.id = id;
    this.entityTypeId = entityTypeId;
    this.properties = properties;
    this.tags = tags;
    this.name = name;
    this.notes = notes;
  }

}