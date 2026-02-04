package com.michaelgiuliano.techevents;

import org.springframework.boot.SpringApplication;

public class TestTechEventsBackendApplication {

    public static void main(String[] args) {
        SpringApplication.from(TechEventsBackendApplication::main).with(TestcontainersConfiguration.class).run(args);
    }

}
