package com.kafka.libraryeventsconsumer.libraryeventsconsumer.jpa;

import com.kafka.libraryeventsconsumer.libraryeventsconsumer.entity.LibraryEvent;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LibraryEventsRepository extends JpaRepository<LibraryEvent,Integer> {
}
