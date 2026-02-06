package com.michaelgiuliano.techevents.web;

import ch.qos.logback.classic.Logger;
import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.core.read.ListAppender;
import com.michaelgiuliano.techevents.support.LoggingTestController;
import org.junit.jupiter.api.Test;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@WebMvcTest(controllers = LoggingTestController.class,
            excludeAutoConfiguration = org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration.class)
public class RequestIdFilterTest {

    @Autowired
    private MockMvc mockMvc;

    // This test assumes the X-Request-Id header is provided; the filter also generates a UUID if missing.
    @Test
    void requestIdIsPopulatedInLog() throws Exception {
        Logger logger = (Logger) LoggerFactory.getLogger("com.michaelgiuliano.techevents");

        ListAppender<ILoggingEvent> listAppender = new ListAppender<>();
        listAppender.start();
        logger.addAppender(listAppender);

        String testRequestId = UUID.randomUUID().toString();

        mockMvc.perform(get("/test/logging")
                        .header("X-Request-Id", testRequestId))
                .andReturn();

        ILoggingEvent logEventWithRequestId = listAppender.list.stream()
                .filter(event -> event.getMDCPropertyMap().containsKey("requestId"))
                .findFirst()
                .orElseThrow(() -> new AssertionError("No log contains requestId"));

        String loggedRequestId = logEventWithRequestId.getMDCPropertyMap().get("requestId");
        assertThat(loggedRequestId).isEqualTo(testRequestId);
    }
}
