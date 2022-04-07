package com.book.management.controller;

import com.book.management.dto.request.AddNewBookRequest;
import com.book.management.dto.request.UpdateBookRequest;
import com.book.management.dto.response.BookResponse;
import com.book.management.entity.Book;
import com.book.management.service.BookService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;


@Slf4j
@RestController
@RequestMapping(path = "/api/v1/books")
@Tag(name = "BOOK API", description = "CRUD book data")
public class BookController {

  @Autowired
  private BookService bookService;

  @Autowired
  private ModelMapper modelMapper;

  @GetMapping
  public List<BookResponse> findAllBook(){
    return bookService.findAllBook().stream().map(book ->
            modelMapper.map(book, BookResponse.class)).collect(Collectors.toList());
  }

  @GetMapping("/author/{bookAuthor}")
  public List<BookResponse> getBookAuthor(
          @PathVariable(value = "bookAuthor") String bookAuthor
  ){
    return bookService.getBookAuthor(bookAuthor).stream().map(book ->
            modelMapper.map(book, BookResponse.class)).collect(Collectors.toList());
  }

  @GetMapping("{bookId}")
  public BookResponse getBook(
          @PathVariable(value="bookId") Integer bookId){
    log.info("Invoking get on /api/book/{bookId} route");
    return bookService.getBook(bookId);
  }

  @PostMapping
  public BookResponse addNewBook(
          @RequestBody AddNewBookRequest addNewBookRequest){
    return bookService.addNewBook(addNewBookRequest);
  }

  @PutMapping("{bookId}")
  public BookResponse updateBook(
          @PathVariable Integer bookId,
          @RequestBody UpdateBookRequest bookRequest){
    log.info("Invoking put on api/book/update route");
    return bookService.updateBook(bookId, bookRequest);
  }

}
