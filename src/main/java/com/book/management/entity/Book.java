package com.book.management.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;


@Data
@Entity
@Table(name = "book")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@NamedQueries(value = {
        @NamedQuery(name = "Book.findAuthorBook", query = "SELECT b FROM Book b WHERE b.bookAuthor=?1")
})
public class Book {

  @CreationTimestamp
  private LocalDateTime createdDate;

  @UpdateTimestamp
  private LocalDateTime updatedDate;

  //------- field from ERD ----/

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column
  private Integer bookId;

  @Column
  private Integer isbn;

  @Column
  private String bookTitle;

  @Column
  private String bookAuthor;

}
