package com.book.management.repository;

import com.book.management.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {
  //public Optional<Book> findFirstByOrderByBookId();
  @Query(value = "SElECT * FROM Book b where b.isbn = ?1", nativeQuery = true)
  //Optional<Book> findBookByIsbn(Integer isbn);
  Optional<Book> findIsbnBook(Integer isbn);
  List<Book> findAuthorBook(String bookAuthor);
}
