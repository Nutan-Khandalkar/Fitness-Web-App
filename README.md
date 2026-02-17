# FitnessWebApp

A microservices-based fitness application built with Spring Boot and Eureka for service discovery.

## Architecture

This project consists of multiple microservices:

- **Eureka Server**: Service discovery and registration
- **UserService**: Handles user management and authentication
- **ActivityService**: Manages fitness activities and tracking
- **AIService**: Provides AI-powered fitness recommendations and insights

## Prerequisites

- Java 11 or higher
- Maven 3.6+
- Git

## Building the Project

1. Clone the repository:
   ```bash
   git clone <repository-url>
   cd FitnessWebApp
   ```

2. Build all services:
   ```bash
   mvn clean install
   ```

## Running the Services

1. Start the Eureka Server first:
   ```bash
   cd eureka
   mvn spring-boot:run
   ```

2. Start the other services in separate terminals:
   ```bash
   # UserService
   cd userservice
   mvn spring-boot:run

   # ActivityService
   cd activityservice
   mvn spring-boot:run

   # AIService
   cd aiservice
   mvn spring-boot:run
   ```

3. Access the Eureka dashboard at: http://localhost:8761

## Configuration

Each service has its own `application.properties` file in `src/main/resources/`. Update the configurations as needed for your environment.

## API Documentation

Once the services are running, you can access Swagger UI for API documentation at:
- UserService: http://localhost:<port>/swagger-ui.html
- ActivityService: http://localhost:<port>/swagger-ui.html
- AIService: http://localhost:<port>/swagger-ui.html

## Contributing

1. Fork the repository
2. Create a feature branch
3. Make your changes
4. Run tests
5. Submit a pull request

## License

This project is licensed under the MIT License.