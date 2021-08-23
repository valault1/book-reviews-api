package ault.BookReviews.repositories;
import ault.BookReviews.models.EntityType;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;

public interface EntityTypeRepository extends MongoRepository<EntityType, String>{
  List<EntityType> findByEntityTypeName(@Param("name") String name);
}
