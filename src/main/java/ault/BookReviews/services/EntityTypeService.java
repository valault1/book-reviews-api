package ault.BookReviews.services;

import ault.BookReviews.repositories.*;
import ault.BookReviews.models.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;


@Service
public class EntityTypeService {
    private final EntityTypeRepository _entityTypeRepository;

    @Autowired
    public EntityTypeService(EntityTypeRepository _entityTypeRepository) {
        this._entityTypeRepository = _entityTypeRepository;
    }

    @Transactional
    public Optional<EntityType> entityType(String id) {
      return _entityTypeRepository.findById(id);
    }

    @Transactional
    public List<EntityType> entityTypes() {
      return _entityTypeRepository.findAll();
    }

    @Transactional
    public long entityTypeCount() {
      return _entityTypeRepository.count();
    }

    @Transactional
    public String createEntityType(EntityType newEntityType) {
      _entityTypeRepository.save(newEntityType);
      return newEntityType.getId();
      
      
    }

    @Transactional
    public String updateEntityType(EntityType updatedEntityType) {
      _entityTypeRepository.save(updatedEntityType);
      return updatedEntityType.getId();
    }

    
}
