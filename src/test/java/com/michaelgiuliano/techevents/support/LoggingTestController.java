package com.michaelgiuliano.techevents.support;

import ch.qos.logback.classic.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoggingTestController {

    private static final Logger log = (Logger) LoggerFactory.getLogger("com.michaelgiuliano.techevents");

    @GetMapping("/test/logging")
    public String handle() {
        log.info("LoggingTestController called");
        return "ok";
    }
}
