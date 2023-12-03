package com.kafka.libraryeventsconsumer.libraryeventsconsumer.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Book {
    @Id
    Integer bookId;

    String bookName;

    String bookAuthor;
    @OneToOne
    @JoinColumn(name="libraryEventId")
    private LibraryEvent libraryEvent;
}