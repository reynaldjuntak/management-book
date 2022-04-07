package com.book.management.service.impl;

import com.book.management.dto.request.AddNewBookRequest;
import com.book.management.dto.response.BookResponse;
import com.book.management.dto.request.UpdateBookRequest;
import com.book.management.entity.Book;
import com.book.management.repository.BookRepository;
import com.book.management.service.BookService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Slf4j
@Service
public class BookServiceImpl implements BookService {

  @Autowired
  private BookRepository bookRepository;

  @Override
  public List<Book> findAllBook() {
    return bookRepository.findAll();
  }

  @Override
  public List<Book> getBookAuthor(String bookAuthor) {
    return bookRepository.findAuthorBook(bookAuthor);
  }

  @Override
  public BookResponse getBook(Integer id) {

    Book bookModel = bookRepository.findById(id).orElseThrow(() ->
      new ResponseStatusException(HttpStatus.NOT_FOUND));

      log.info("Latest assignment record found !");

    return BookResponse.builder()
            .bookId(bookModel.getBookId())
            .isbn(bookModel.getIsbn())
            .bookTitle(bookModel.getBookTitle())
            .bookAuthor(bookModel.getBookAuthor())
            .build();
  }

  @Override
  public BookResponse addNewBook(AddNewBookRequest newBookRequest) {
    Optional<Book> bookOptional = bookRepository.findIsbnBook(newBookRequest.getIsbn());
    if (bookOptional.isPresent()){
      throw new IllegalStateException("Isbn taken");
    }

    Book bookModel = Book.builder()
            .isbn(newBookRequest.getIsbn())
            .bookTitle(newBookRequest.getBookTitle())
            .bookAuthor(newBookRequest.getBookAuthor())
            .build();

    Book newBook = bookRepository.save(bookModel);

    log.info("Book added");

    return BookResponse.builder()
            .bookId(newBook.getBookId())
            .isbn(newBook.getIsbn())
            .bookTitle(newBook.getBookTitle())
            .bookAuthor(newBook.getBookAuthor())
            .build();
  }

  @Override
  public BookResponse updateBook(Integer bookId, UpdateBookRequest updateBookRequest){
    Book bookModel = bookRepository.findById(updateBookRequest.getBookId()).orElseThrow(() ->
      new ResponseStatusException(HttpStatus.NOT_FOUND));

    bookModel.setBookId(updateBookRequest.getBookId());
    bookModel.setIsbn(updateBookRequest.getIsbn());
    bookModel.setBookTitle(updateBookRequest.getBookTitle());
    bookModel.setBookAuthor(updateBookRequest.getBookAuthor());

    Book bookResponse = bookRepository.save(bookModel);

    log.info("Book record with bookId {} found and updated !", updateBookRequest.getBookId());

    return BookResponse.builder()
            .bookId(bookResponse.getBookId())
            .isbn(bookResponse.getIsbn())
            .bookTitle(bookResponse.getBookTitle())
            .bookAuthor(bookResponse.getBookAuthor())
            .build();
  }

}
