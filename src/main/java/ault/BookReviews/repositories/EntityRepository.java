package ault.BookReviews.repositories;
import ault.BookReviews.models.Entity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface EntityRepository extends MongoRepository<Entity, String>{
  
}
