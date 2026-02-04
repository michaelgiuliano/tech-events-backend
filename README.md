# Tech Events Backend

Production-style **Spring Boot backend** for tech conferences: scheduling (DST-safe), ticketing with concurrency guarantees, JWT auth with refresh rotation, and an outbox-based notifications worker (PostgreSQL + Flyway + Testcontainers).

This repository is intentionally built as a portfolio project with production-minded correctness (PostgreSQL constraints, concurrency-safe ticketing, strict time/DST handling).

## Tech Stack

- Java 21, Spring Boot 3.x (Web, Validation, Security, Data JPA)
- PostgreSQL + Flyway
- OpenAPI (springdoc)
- Tests: JUnit 5 + Testcontainers (PostgreSQL)

## Status

Work in progress. The API and schema will evolve until the first stable release.

## Roadmap

Implementation is tracked as a milestone-driven backlog (kept private while the project is under active development).

## License

TBD.
