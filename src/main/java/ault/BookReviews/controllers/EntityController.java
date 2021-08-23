package ault.BookReviews.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import ault.BookReviews.models.Entity;
import ault.BookReviews.models.Requests.CreateEntityRequest;
import ault.BookReviews.services.EntityService;

@CrossOrigin(origins = "*")
@RestController
public class EntityController {
  private final EntityService _entityService;

  @Autowired
  public EntityController(EntityService entityService) {
    this._entityService = entityService;
  }

  @GetMapping("/Entity/count")
  public long entityCount() {
    return _entityService.entityCount();
  }

  @GetMapping("/Entity/Entities")
  public List<Entity> projects() {
    System.out.println("Got request for all entities");
    return _entityService.entities();
  }

  @PutMapping("/Entity")
  public String createEntity(@RequestBody CreateEntityRequest newEntityRequest) {
    System.out.println(newEntityRequest);
    return _entityService.createEntity(newEntityRequest);
  }

  @PostMapping("/Entity")
  public String updateEntity(@RequestBody Entity updatedEntity) {
    System.out.println("Got request to update entity");
    return _entityService.updateEntity(updatedEntity);
  }

  @GetMapping("/Entity/tags")
  public List<String> getTags() {
    System.out.println("Got request for tags!");
    return _entityService.getTags();
  }

}