package ault.BookReviews.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import ault.BookReviews.models.BookReview;
import ault.BookReviews.services.BookReviewService;
import ault.BookReviews.services.DTOs.BookReviewDTO;

@CrossOrigin(origins = "*")
@RestController
public class BookReviewController {
  private final BookReviewService _bookReviewService;

  @Autowired
  public BookReviewController(BookReviewService bookReviewService) {
    this._bookReviewService = bookReviewService;
  }

  @GetMapping("/bookReview/count")
  public long projectCount() {
    return _bookReviewService.projectCount();
  }

  @GetMapping("/bookReview/projects")
  public List<BookReviewDTO> bookReviews() {
    return _bookReviewService.bookReviews();
  }

  @PutMapping("/bookReview")
  public String createProject(@RequestBody BookReview newBookReview) {
    return _bookReviewService.createBookReview(newBookReview);
  }

  @PostMapping("/bookReview")
  public String updateProject(@RequestBody BookReview updatedBookReview) {
    return _bookReviewService.updateBookReview(updatedBookReview);
  }

}
