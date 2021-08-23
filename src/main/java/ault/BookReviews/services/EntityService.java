package ault.BookReviews.services;

import ault.BookReviews.repositories.*;
import ault.BookReviews.models.*;
import ault.BookReviews.models.Exceptions.EntityNotFoundException;
import ault.BookReviews.models.Exceptions.EntityNotValidException;
import ault.BookReviews.models.Requests.CreateEntityRequest;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
@Transactional
public class EntityService {
  private final EntityRepository _entityRepository;
  private final EntityTypeRepository _entityTypeRepository;

  @Autowired
  public EntityService(EntityRepository entityRepository, EntityTypeRepository entityTypeRepository) {
    this._entityRepository = entityRepository;
    this._entityTypeRepository = entityTypeRepository;
  }

  public Optional<Entity> entity(String id) {
    return _entityRepository.findById(id);
  }

  public List<Entity> entities() {
    return _entityRepository.findAll();
  }

  public long entityCount() {
    return _entityRepository.count();
  }

  // Complicated process.
  // To create an entity, we must check the entity they give us against the
  // schema, and if it all matches, then it's ok
  public String createEntity(CreateEntityRequest newEntityRequest) {

    EntityType et = _entityTypeRepository.findById(newEntityRequest.getEntityTypeId()).get();
    var newEntity = (Map<String, String>) newEntityRequest.getEntityProperties();
    System.out.println(newEntity);

    var populatedProperties = validateEntity(et, newEntity);
    var entity = new Entity(newEntityRequest.getEntityTypeId(), populatedProperties, newEntityRequest.getTags(),
        newEntityRequest.getName());
    _entityRepository.save(entity);

    // If it made it this far, it is valid

    System.out.println("Passed! :)");

    return "";
  }

  public String updateEntity(Entity updatedEntity) {
    System.out.println(updatedEntity);
    _entityRepository.save(updatedEntity);
    return updatedEntity.getId();
  }

  public List<String> getTags() {
    var entities = entities();
    var result = new ArrayList<String>();
    for (var entity : entities) {
      for (var tag : entity.getTags()) {
        if (!result.contains(tag)) {
          result.add(tag);
        }

      }
    }
    return result;
  }

  private List<EntityProperty> validateEntity(EntityType et, Map<String, String> newEntity) {
    var populatedProperties = new ArrayList<EntityProperty>();
    var propertyNames = new ArrayList<String>();
    for (var prop : et.getProperties()) {
      propertyNames.add(prop.getPropertyName());
    }

    var isValid = true;
    for (Map.Entry<String, String> entry : newEntity.entrySet()) {
      if (propertyNames.contains(entry.getKey())) {
        System.out.println("The name " + entry.getKey() + " was found in the property list!");
        // make sure the field is valid. ex. if it should be a reference, it must be a
        // valid reference
        EntitySchemaProperty prop = et.getProperties().stream().filter(p -> p.getPropertyName().equals(entry.getKey()))
            .findFirst().get();
        var isParsable = parseField(prop, entry.getKey(), entry.getValue());
        if (isParsable) {
          var ep = new EntityProperty(prop, entry.getValue());
          populatedProperties.add(ep);
        } else {
          isValid = false;
          throw new EntityNotValidException(this.getClass(), entry.getKey());
        }
      } else {
        isValid = false;
        System.out.println(entry.getKey() + " NOT FOUND");
        throw new EntityNotValidException(this.getClass(), entry.getKey());
      }
    }
    return populatedProperties;

  }

  private boolean parseField(EntitySchemaProperty prop, String propName, String propValue) {
    // First, find the property that corresponds to the one we're analyzing

    System.out.println("Parsing field " + propName);
    if (prop.getPropertyType().equals("String")) {
      System.out.println("This is a valid string!");
      return true;
    }

    return false;
  }

}
