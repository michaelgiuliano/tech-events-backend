# Tech Events Backend

Production-style **Spring Boot backend** for tech conferences: scheduling (DST-safe), ticketing with concurrency guarantees, JWT auth with refresh rotation, and an outbox-based notifications worker (PostgreSQL + Flyway + Testcontainers).

This repository is intentionally built as a portfolio project with production-minded correctness (PostgreSQL constraints, concurrency-safe ticketing, strict time/DST handling).

---

## Tech Stack

- Java 21, Spring Boot 3.x (Web, Validation, Security, Data JPA)
- PostgreSQL + Flyway
- OpenAPI (springdoc)
- Tests: JUnit 5 + Testcontainers (PostgreSQL)

## Status

Work in progress. The API and schema will evolve until the first stable release.

## Prerequisites

- **Java 21**
- **Maven 4+** (or wrapper included)
- **Docker** (running, required for Testcontainers PostgreSQL)

## Build

To build the project:

```bash
./mvnw clean package
```
This will compile the project and run all tests.

## Run Tests
Tests use Testcontainers to spin up PostgreSQL automatically. Make sure Docker is running:

```bash
./mvnw test
```
All tests are isolated and do not require a local database.

## Run Locally
The application is designed to run locally using environment variables and the dev profile.

### 1. Environment variables
Copy the example environment file and adjust values as needed:

```bash
cp .env.example .env
```

## Roadmap

Implementation is tracked as a milestone-driven backlog (kept private while the project is under active development).

## License

TBD.

---