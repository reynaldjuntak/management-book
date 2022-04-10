//package com.book.management.controller;
//
//import com.book.management.dto.response.BookResponse;
//import com.book.management.entity.Book;
//import com.book.management.service.BookService;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Disabled;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.test.context.ActiveProfiles;
//import org.springframework.test.web.servlet.MockMvc;
//
//import java.time.LocalDateTime;
//
//import static org.junit.jupiter.api.Assertions.*;
//import static org.mockito.BDDMockito.given;
//import static org.mockito.Mockito.times;
//import static org.mockito.Mockito.verify;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//
//@WebMvcTest(controllers = BookController.class)
//@ActiveProfiles("test")
//class BookControllerTest {
//
//    @Autowired
//    private MockMvc mockMvc;
//
//    @MockBean
//    private BookService bookService;
//
//    Book bookModel;
//
//    @BeforeEach
//    void setUp() {
//        //given
//        bookModel = new Book(
//                //LocalDateTime.parse("2022-01-02T14:06:59.972177"),
//                //LocalDateTime.parse("2022-01-02T14:06:59.972177"),
//                2,
//                123456,
//                "The Alchemist",
//                "Paulo Coelho");
//    }
//
//    @Test
//    @Disabled
//    void shouldGetABook() throws Exception {
//        //BookResponse builder = BookResponse.builder().data(bookModel).build();
//        //given(bookService.getBook(2)).willReturn(builder);
//
//        BookResponse response = bookService.getBook(2);
//
//        //when
//        mockMvc.perform(get("/api/book/{bookId}", bookModel.getBookId()))
//
//        //then
//                .andExpect(status().isOk())
//                //.andExpect(jsonPath("$.data.createdDate").value(bookModel.getCreatedDate().toString()))
//                //.andExpect(jsonPath("$.data.updatedDate").value(bookModel.getUpdatedDate().toString()))
//                .andExpect(jsonPath("$.data.bookId").value(bookModel.getBookId()))
//                .andExpect(jsonPath("$.data.isbn").value(bookModel.getIsbn()))
//                .andExpect(jsonPath("$.data.bookTitle").value(bookModel.getBookTitle()))
//                .andExpect(jsonPath("$.data.bookAuthor").value(bookModel.getBookAuthor()));
//
//        //assertEquals(builder, response);
//        verify(bookService, times(2)).getBook(2);
//
//    }
//}