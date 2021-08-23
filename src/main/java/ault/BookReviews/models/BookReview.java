package ault.BookReviews.models;

import lombok.Data;

import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
public class BookReview {

  public enum MediaType{
    BOOK,
    TEDTALK,
    ARTICLE
  }

  public String id;
  
  // The book reviewed in this review
  public String bookId;

  public BookReview(String id, String bookId) {
    this.id=id;
    this.bookId=bookId;
  }

  public MediaType mediaType;

  


}