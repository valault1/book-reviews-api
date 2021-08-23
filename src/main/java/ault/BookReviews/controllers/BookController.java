package ault.BookReviews.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import ault.BookReviews.models.Book;
import ault.BookReviews.services.BookService;

@CrossOrigin(origins = "*")
@RestController
public class BookController {
  private final BookService _bookService;

  @Autowired
  public BookController(BookService bookService) {
    this._bookService = bookService;
  }

  @GetMapping("/book/count")
  public long projectCount() {
    return _bookService.projectCount();
  }

  @GetMapping("/book/projects")
  public List<Book> projects() {
    return _bookService.projects();
  }

  @PutMapping("/book")
  public String createProject(@RequestBody Book newBook) {
    return _bookService.createBook(newBook);
  }

  @PostMapping("/book")
  public String updateProject(@RequestBody Book updatedBook) {
    return _bookService.updateBook(updatedBook);
  }

}