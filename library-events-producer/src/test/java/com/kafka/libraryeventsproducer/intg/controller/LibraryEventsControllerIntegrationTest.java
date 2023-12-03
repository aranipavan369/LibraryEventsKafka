package com.kafka.libraryeventsproducer.intg.controller;

import com.kafka.libraryeventsproducer.domain.LibraryEvent;
import com.kafka.libraryeventsproducer.intg.util.TestUtil;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.*;
import org.springframework.kafka.test.context.EmbeddedKafka;
import org.springframework.test.context.TestPropertySource;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@EmbeddedKafka(topics = "library-events")
@TestPropertySource(properties = {"spring.kafka.producer.bootstrap-servers=${spring.embedded.kafka.brokers}",
        "spring.kafka.admin.properties.bootstrap.servers=${spring.embedded.kafka.brokers}"})
class LibraryEventsControllerIntegrationTest {
    @Autowired
    TestRestTemplate restTemplate;

    @Test
    void postLibraryEvent() {
        //given
        LibraryEvent libraryEvent = TestUtil.libraryEventRecordWithInvalidBook();

        HttpHeaders headers = new HttpHeaders();
        headers.set("content-type", MediaType.APPLICATION_JSON.toString());
        HttpEntity<LibraryEvent> request = new HttpEntity<>(libraryEvent, headers);


        //when
        var responseEntity=restTemplate
                .exchange("/v1/libraryevent", HttpMethod.POST,request,LibraryEvent.class);


        //then
        assertEquals(HttpStatus.CREATED,responseEntity.getStatusCode());
    }
}