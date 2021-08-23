package ault.BookReviews.DataInitialization;

import ault.BookReviews.repositories.*;
import ault.BookReviews.models.*;
import ault.BookReviews.models.BookReview.MediaType;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.Date;

import javax.annotation.PostConstruct;

import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class DataFillerService {
    private final ProjectRepository _projectRepository;
    private final BookRepository _bookRepository;
    private final BookReviewRepository _bookReviewRepository;
    private final EntityTypeRepository _entityTypeRepository;
    private final EntityRepository _entityRepository;

    @Autowired
    public DataFillerService(ProjectRepository projectRepository,
                             BookRepository bookRepository, 
                             BookReviewRepository bookReviewRepository,
                             EntityRepository entityRepository,
                             EntityTypeRepository entityTypeRepository) {
        this._projectRepository = projectRepository;
        this._bookRepository = bookRepository;
        this._bookReviewRepository = bookReviewRepository;
        this._entityRepository = entityRepository;
        this._entityTypeRepository = entityTypeRepository;
    }

    @PostConstruct
    @Transactional
    public void fillData(){
        fillProjects();
        fillBooks();
        fillBookReviews();
        try {
          fillEntities();
          fillEntityTypes();
        } catch (Exception e) {System.out.println(e);}
        
        System.out.println("Filled data!");
        
    }

    private void fillProjects() {
        ProjectTask task1 = new ProjectTask("Work out on Tuesday");
        String projectId = "609576a2018e164aa8e9de04";
        ArrayList<ProjectTask> tasksList = new ArrayList<ProjectTask>();
        tasksList.add(task1);
        Project proj = new Project(projectId, "Project 2", new Date(),tasksList);
        _projectRepository.save(proj);
        
    }

    private void fillBooks() {
      ArrayList<String> tags = new ArrayList<String>();
      String bookId = "6095782d018e164aa8e9de1b";
      tags.add("Productivity");
      tags.add("Wisdom");
      Book book1 = new Book(bookId, "7 Habits", tags );
      _bookRepository.save(book1);
    }

    private void fillBookReviews() {
      String id = "6095782d018e164aa8e9de1c";
      String bookId = "6095782d018e164aa8e9de1b";
      BookReview br = new BookReview(id, bookId);
      br.mediaType = MediaType.BOOK;
      System.out.println(br);
      _bookReviewRepository.save(br);
    }

    private void fillEntities() throws Exception{
      JSONArray obj =(JSONArray) new JSONParser().parse(new FileReader("src\\main\\java\\ault\\BookReviews\\DataInitialization\\data\\entities.json"));
      for (var item : obj) {
        ObjectMapper objectMapper = new ObjectMapper();
        System.out.println("Attempting to write entity");
        Entity e = objectMapper.readValue(item.toString(), Entity.class);
        _entityRepository.save(e);
      }
      
      
    }

    private void fillEntityTypes() throws Exception{
      JSONArray obj =(JSONArray) new JSONParser().parse(new FileReader("src\\main\\java\\ault\\BookReviews\\DataInitialization\\data\\entity-types.json"));
      for (var item : obj) {
        ObjectMapper objectMapper = new ObjectMapper();
        EntityType e = objectMapper.readValue(item.toString(), EntityType.class);
        _entityTypeRepository.save(e);
      }
    }
}
