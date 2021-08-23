package ault.BookReviews.services;

import ault.BookReviews.repositories.*;
import ault.BookReviews.models.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;


@Service
public class BookService {
    private final BookRepository _bookRepository;

    @Autowired
    public BookService(BookRepository _bookRepository) {
        this._bookRepository = _bookRepository;
    }

    @Transactional
    public Optional<Book> project(String id) {
      return _bookRepository.findById(id);
    }

    @Transactional
    public List<Book> projects() {
      return _bookRepository.findAll();
    }

    @Transactional
    public long projectCount() {
      return _bookRepository.count();
    }

    @Transactional
    public String createBook(Book newBook) {
      _bookRepository.save(newBook);
      return newBook.getId();
      
      
    }

    @Transactional
    public String updateBook(Book updatedBook) {
      _bookRepository.save(updatedBook);
      return updatedBook.getId();
    }

    
}
