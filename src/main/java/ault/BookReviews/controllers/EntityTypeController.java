package ault.BookReviews.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import ault.BookReviews.models.EntityType;
import ault.BookReviews.services.EntityTypeService;

@CrossOrigin(origins = "*")
@RestController
public class EntityTypeController {
  private final EntityTypeService _entityTypeService;

  @Autowired
  public EntityTypeController(EntityTypeService entityTypeService) {
    this._entityTypeService = entityTypeService;
  }

  @GetMapping("/EntityType/count")
  public long entityTypeCount() {
    return _entityTypeService.entityTypeCount();
  }

  @GetMapping("/EntityType/EntityTypes")
  public List<EntityType> projects() {
    return _entityTypeService.entityTypes();
  }

  @PutMapping("/EntityType")
  public String createEntityType(@RequestBody EntityType newEntityType) {
    return _entityTypeService.createEntityType(newEntityType);
  }

  @PostMapping("/EntityType")
  public String updateProject(@RequestBody EntityType updatedEntityType) {
    return _entityTypeService.updateEntityType(updatedEntityType);
  }

}