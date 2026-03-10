<div align="center">

# API Gateway + Pipeline Architecture + Payment

<p>
  A study-driven backend project that combines an <b>API Gateway</b> with a <b>pipeline-based payment workflow</b>, using Spring ecosystem components to explore request routing, validation, payment processing, and notification orchestration.
</p>

<p>
  <a href="https://www.java.com"><img src="https://skillicons.dev/icons?i=java,spring,docker,mongodb,gradle,aws" alt="Tech Stack" /></a>
</p>

<p>
  <img src="https://img.shields.io/badge/Java-21-blue" alt="Java 21" />
  <img src="https://img.shields.io/badge/Spring_Boot-4.0.3-6DB33F" alt="Spring Boot 4.0.3" />
  <img src="https://img.shields.io/badge/Spring_Cloud-2025.1.0-6DB33F" alt="Spring Cloud 2025.1.0" />
  <img src="https://img.shields.io/badge/MongoDB-Document_Database-47A248" alt="MongoDB" />
  <img src="https://img.shields.io/badge/Architecture-Pipeline-orange" alt="Pipeline Architecture" />
  <img src="https://img.shields.io/badge/Status-Phase_1_%26_2-informational" alt="Status" />
</p>

</div>

---

## Overview

This repository is a hands-on architecture study focused on building a payment flow behind an API Gateway.

The project explores how to:
- expose a single entry point through **Spring Cloud Gateway**;
- organize the business workflow as a **pipeline of processing steps**;
- validate incoming requests before executing the business flow;
- apply **payment strategies** for different payment behaviors;
- trigger **notifications** such as e-mail and SMS-like integrations;
- keep the codebase simple and pragmatic while still applying architectural thinking.

At this stage, this README documents the project as **Phase 1 + Phase 2 only**, without OAuth2 as part of the delivered scope.

---

## Architecture Goal

The main purpose of this project is not only to build a functional backend, but also to study how different architectural styles and patterns work together in practice:

- **API Gateway** as the system entry point;
- **Pipeline Architecture** for step-by-step workflow execution;
- **Layered Architecture** with some domain-oriented isolation;
- **Strategy Pattern** for payment behavior variations;
- **Factory Pattern** for notification channel creation.

This makes the repository a good sandbox for learning about orchestration, request flow design, and pragmatic backend architecture with Spring.

---

## Project Scope

### Phase 1 — Core Pipeline Flow
- Request enters through the gateway
- Gateway forwards the request to the payment pipeline service
- Pipeline executes the processing steps in order
- Validation is performed before business execution
- Payment flow is processed and a response is returned

### Phase 2 — Notification Support
- Notification step is included in the workflow
- Notifications can be sent through **e-mail**
- The design also considers **SMS-style integration** (for example, AWS SNS)
- Notification creation is structured through a factory-based approach

> OAuth2 / Authorization Server is intentionally not included in this version of the README, since the current documented scope stops at Phase 2.

---

## High-Level Flow

```text
Client
  |
  v
API Gateway
  |
  v
Pipeline Service
  |
  +--> Validation Step
  |
  +--> Payment Step
  |
  +--> Notification Step
  |
  v
Response
```

---

## Architecture Diagram

<div align="center">
  <img src="https://raw.githubusercontent.com/felipematheus1337/api-gateway-pipeline-architecture-payment/develop/assets/architecture-draw.JPG" alt="Architecture Diagram" width="900" />
</div>

---

## Modules

### 1. `api-gateway`
Gateway module responsible for acting as the system entry point.

**Main responsibilities**
- centralize incoming HTTP traffic;
- route requests to downstream services;
- provide a good place for cross-cutting concerns in future evolutions;
- represent the external-facing boundary of the platform.

**Main technologies**
- Spring Boot
- Spring Cloud Gateway Server Web MVC
- Micrometer / tracing support
- Lombok
- Gradle

### 2. `pipeline-service`
Business module responsible for orchestrating the payment workflow.

**Main responsibilities**
- receive routed requests from the gateway;
- validate request payloads;
- apply payment logic;
- trigger notification logic;
- persist or query data through MongoDB when needed.

**Main technologies**
- Spring Boot
- Spring Data MongoDB
- Spring Validation
- Spring Mail
- Spring Web MVC
- Lombok
- Gradle

---

## Tech Stack

| Category | Technologies |
|---|---|
| Language | Java 21 |
| Build Tool | Gradle |
| Backend Framework | Spring Boot |
| Gateway | Spring Cloud Gateway |
| Data | MongoDB |
| Validation | Jakarta Bean Validation / Spring Validation |
| Notifications | Spring Mail, SMS-ready design |
| Observability | Micrometer Tracing / Brave |
| Utilities | Lombok |
| Containerization | Docker-ready project structure |

---

## Patterns and Architectural Decisions

### Pipeline Architecture
The core workflow is modeled as a sequence of steps. This improves readability and makes the business flow easier to evolve as new steps are introduced.

### Layered Architecture
The codebase follows a layered organization, while still preserving some domain separation to keep responsibilities clearer.

### Strategy Pattern
Different payment behaviors can be implemented as separate strategies, reducing conditional complexity and making the payment layer easier to extend.

### Factory Pattern
Notification channels can be created through a factory, which helps decouple channel selection from execution.

---

## Current Features

- API Gateway as single entry point
- Request forwarding to the pipeline service
- Validation step in the workflow
- Payment processing step
- Notification processing step
- E-mail notification support
- SMS-oriented extension point (such as AWS SNS integration)
- MongoDB integration for data persistence scenarios
- Tracing/observability dependencies already introduced in the gateway module

---

## Suggested Request Lifecycle

```text
1. Client sends a request to the API Gateway
2. Gateway routes the request to the pipeline-service
3. Pipeline validates the request data
4. Pipeline selects the appropriate payment strategy
5. Payment is processed
6. Notification factory resolves the notification channel
7. Notification is dispatched
8. Final response is returned to the client
```

---

## Repository Structure

```text
api-gateway-pipeline-architecture-payment/
├── api-gateway/
│   ├── src/
│   ├── build.gradle
│   └── settings.gradle
├── pipeline-service/
│   ├── src/
│   ├── build.gradle
│   └── settings.gradle
├── assets/
│   └── architecture-draw.JPG
└── README.md
```

---

## How to Run

### Prerequisites
- Java 21
- Gradle
- MongoDB
- Docker (optional, but recommended for local infrastructure)

### 1. Clone the repository
```bash
git clone -b develop https://github.com/felipematheus1337/api-gateway-pipeline-architecture-payment.git
cd api-gateway-pipeline-architecture-payment
```

### 2. Start required infrastructure
Start MongoDB locally using your preferred approach.

Example with Docker:
```bash
docker run -d \
  --name mongodb \
  -p 27017:27017 \
  mongo:latest
```

### 3. Run the pipeline service
```bash
cd pipeline-service
./gradlew bootRun
```

### 4. Run the API Gateway
Open another terminal:
```bash
cd api-gateway
./gradlew bootRun
```

---

## Evolution Roadmap

This version documents the project until **Phase 2**.

### Already covered
- Gateway entry point
- Pipeline-oriented workflow
- Validation step
- Payment step
- Notification step

### Possible next evolutions
- OAuth2 / JWT authentication and authorization
- Resilience patterns (retry, circuit breaker, timeout)
- Integration tests with Testcontainers
- Distributed tracing visualization
- Docker Compose for the full environment
- Better API documentation with OpenAPI / Swagger
- Kafka or async messaging for notification decoupling

---

## Why this project matters

This repository is valuable as a portfolio and study project because it demonstrates:
- architectural reasoning instead of only CRUD implementation;
- practical use of Spring Cloud Gateway;
- workflow modeling with pipeline thinking;
- application of classic design patterns in a realistic backend context;
- a clean path for future evolution toward more advanced security and distributed systems concerns.

---

## Author

**Felipe Matheus D'Avila Pereira**

Backend / Full Stack Developer focused on Java, Spring, distributed systems, and software architecture studies.

- GitHub: [felipematheus1337](https://github.com/felipematheus1337)

---

## License

This project is available for study and portfolio purposes.
Add a formal license file if you want to define reuse permissions explicitly.
