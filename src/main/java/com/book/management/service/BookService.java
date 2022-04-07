package com.book.management.service;

import com.book.management.dto.request.AddNewBookRequest;
import com.book.management.dto.response.BookResponse;
import com.book.management.dto.request.UpdateBookRequest;
import com.book.management.entity.Book;

import java.util.List;

public interface BookService {
  List<Book> findAllBook();
  List<Book> getBookAuthor(String bookAuthor);
  BookResponse getBook(Integer bookId);
  BookResponse addNewBook(AddNewBookRequest newBookRequest);
  //void addNewBook(Book book);
  BookResponse updateBook(Integer bookId, UpdateBookRequest updateBookRequest);
}
