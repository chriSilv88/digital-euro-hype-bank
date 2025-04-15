<!-- @format -->

# POC - Digital Euro Backend

This repository hosts a Proof of Concept (POC) backend engineered to manage
Digital Euro functionalities. The application leverages modern Java and Spring
Boot frameworks along with containerized deployment on Azure infrastructure.
This POC is intended to validate integration patterns, secure configuration
management, and scalability strategies using industry-proven technologies.

## Tech Stack

- **Java 21** – Utilize the latest language features for improved performance
  and maintainability.
- **Spring Boot 3.3.x** – Rapid application development with a robust,
  production-grade framework.
- **MongoDB** – A NoSQL database for flexible, high-performance data
  persistence.
- **Azure Kubernetes Service (AKS)** – Container orchestration ensuring scalable
  and resilient deployments.
- **Azure Key Vault** – Centralized management of sensitive information and
  secrets.
- **OpenFeign** – Declarative REST client facilitating inter-service
  communication.
- **Log4j2** – Highly configurable logging for robust application monitoring.
- **Springdoc OpenAPI** – Automatically generates comprehensive API
  documentation.

## Getting Started

### Prerequisites

Ensure you have the following installed and configured before proceeding:

- **JDK 21** – The runtime environment for executing modern Java applications.
- **Maven 3.8+** – Dependency management and build automation tool.
- **Docker** (optional) – For running the application in containerized mode
  during local testing.
- **MongoDB Instance** – Access the `db-digital-euro` database instance.
- **Azure Key Vault Credentials** – Access the secret identified as
  `digital-euro-key` for secure configuration management.

### Local Development

For local development, follow these steps:

1. **Build and Run with Maven:**

   ```bash
   mvn clean install
   mvn spring-boot:run
   ```

   This will compile the project, run unit tests, and start the Spring Boot
   application.

2. **Running with Docker:**

   If you prefer a containerized environment, execute:

   ```bash
   docker build -t poc-digital-euro .
   docker run -p 8080:8080 poc-digital-euro
   ```

   This command builds the Docker image and starts a container exposing
   port 8080.

## Build & Test

Automated builds and tests are a fundamental part of the quality assurance
process. Use the following command to compile the code, run the full test suite,
and generate reports:

```bash
mvn clean verify
```

This command executes:

- **Compilation and Packaging:** Ensuring the code builds without errors.
- **Unit and Integration Tests:** Validating core functionalities and
  integration points.
- **Test Coverage Analysis:** (if configured) to help monitor code quality and
  maintainability.

## Configuration

All sensitive credentials and environment-specific variables are externalized.
These configurations are managed through Azure Key Vault integration and
external configuration files. Specifically:

- **MongoDB URI and Credentials:** Injected securely into the runtime
  environment without hardcoding into the source.
- **Environment Variables:** Managed using configuration management best
  practices, supporting multiple environments (development, staging,
  production).

Developers should refer to the configuration documentation for best practices on
managing secrets and environment-specific parameters.

## Deployment

The application leverages a CI/CD pipeline using Azure Pipelines for seamless
deployment to Azure Kubernetes Service (AKS). Key configuration details include:

- **Namespace:**
  ```yaml
  namespace: poc-digital-euro
  ```
- **CI/CD Workflow:** Automated processes are in place to:
  - Build and test the application code.
  - Package the application into Docker containers.
  - Deploy to AKS with automated rollback in case of deployment failures.

Developers can review the pipeline configuration files in the repository for a
detailed understanding of the deployment workflow.

## 👥 Contributors

This project is the product of collaborative efforts. Current contributors
include:

- Andrea Cavagnet
- Giuseppe Brescia
- Christian Silvestri

Contribution guidelines are documented separately to ensure code quality and
uniformity across the team.

## License

This project is for internal use only and is proprietary to Hype IT.
Redistribution or external use is restricted without prior authorization.
