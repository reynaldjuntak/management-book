//package com.book.management.service.impl;
//
//import com.book.management.dto.response.BookResponse;
//import com.book.management.entity.Book;
//import com.book.management.repository.BookRepository;
//import lombok.extern.slf4j.Slf4j;
//import org.junit.jupiter.api.Disabled;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.junit.jupiter.MockitoExtension;
//
//import static org.assertj.core.api.Assertions.assertThat;
//import static org.mockito.BDDMockito.given;
//
//import java.time.LocalDateTime;
//import java.util.Optional;
//
//import static org.junit.jupiter.api.Assertions.*;
//import static org.mockito.Mockito.times;
//import static org.mockito.Mockito.verify;
//
//@Slf4j
//@ExtendWith(MockitoExtension.class)
//class BookServiceImplTest {
//
//    @Mock
//    BookRepository bookRepository;
//
//    @InjectMocks
//    BookServiceImpl bookServiceImpl;
//
//    @Test
//    @Disabled
//    void getBook() {
//        Book bookModel = new Book(
//                //LocalDateTime.now(),
//                //LocalDateTime.now(),
//                2,
//                123456,
//                "The Alchemist",
//                "Paulo Coelho");
//
//        given(bookRepository.findById(2)).willReturn(Optional.of(bookModel));
//
//        BookResponse dataBook = BookResponse.builder()
//                //.data(bookModel)
//                .build();
//
//        BookResponse response = bookServiceImpl.getBook(2);
//
//        verify(bookRepository, times(1)).findById(2);
//        assertThat(response).isNotNull();
//        assertEquals(response, dataBook);
//
//        //System.out.println(response);
//        log.info(response.toString());
//
//        //check if the book is not found will return http not found
//    }
//}