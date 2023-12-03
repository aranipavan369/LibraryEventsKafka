package com.kafka.libraryeventsproducer.domain;

public record LibraryEvent(
        Integer libraryEventId,
        LibraryEventtype libraryEventType,

        Book book
) {
}
