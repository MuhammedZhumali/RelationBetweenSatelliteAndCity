# SatelliteToCity

A Spring Boot REST API application for tracking satellite positions and their intersections with cities around the world.

## Overview

SatelliteToCity is a web service that provides information about cities and their relationships with satellite data. The application manages city information including geographic coordinates and can be extended to calculate satellite intersections with cities.

## Features

- RESTful API for city information retrieval
- In-memory city database with 13 pre-loaded cities
- Support for satellite position tracking (DTOs included)
- Intersection calculation support between satellites and cities

## Technology Stack

- **Java 17**
- **Spring Boot 3.5.7**
- **Spring Web** - REST API support
- **Lombok** - Reduces boilerplate code
- **Maven** - Dependency management and build tool

## Prerequisites

- Java 17 or higher
- Maven 3.6+ (or use the included Maven wrapper)

## Getting Started

### Building the Project

```bash
# Using Maven wrapper (recommended)
./mvnw clean install

# Or using system Maven
mvn clean install
```

### Running the Application

```bash
# Using Maven wrapper
./mvnw spring-boot:run

# Or using system Maven
mvn spring-boot:run
```

The application will start on the default port `8080`.

### Running Tests

```bash
./mvnw test
```

## API Endpoints

### Get City by ID

Retrieve city information by its ID.

**Endpoint:** `GET /city/get/{cityId}`

**Path Parameters:**
- `cityId` (Long) - The unique identifier of the city

**Response:**
```json
{
  "id": 1,
  "name": "Astana",
  "latitudeDeg": 51.169392,
  "longitudeDeg": 71.449074
}
```

**Example:**
```bash
curl http://localhost:8080/city/get/1
```

**Error Response:**
If the city is not found, the API returns a 500 error with the message "City not found".

## Pre-loaded Cities

The application comes with 13 cities pre-loaded:

1. **Astana** (Kazakhstan) - 51.169392°N, 71.449074°E
2. **Almaty** (Kazakhstan) - 43.238949°N, 76.889709°E
3. **Shymkent** (Kazakhstan) - 42.3417°N, 69.5901°E
4. **New York** (USA) - 40.7128°N, 74.0060°W
5. **Los Angeles** (USA) - 34.0522°N, 118.2437°W
6. **Chicago** (USA) - 41.8781°N, 87.6298°W
7. **San Francisco** (USA) - 37.7749°N, 122.4194°W
8. **London** (UK) - 51.5074°N, 0.1278°W
9. **Paris** (France) - 48.8566°N, 2.3522°E
10. **Berlin** (Germany) - 52.5200°N, 13.4050°E
11. **Tokyo** (Japan) - 35.6895°N, 139.6917°E
12. **Seoul** (South Korea) - 37.5665°N, 126.9780°E
13. **Dubai** (UAE) - 25.2048°N, 55.2708°E

## Project Structure

```
src/
├── main/
│   ├── java/
│   │   └── org/
│   │       └── satellitetocity/
│   │           ├── SatelliteToCItyApplication.java    # Main application class
│   │           ├── controller/
│   │           │   └── CityController.java           # REST controller
│   │           ├── service/
│   │           │   └── CityService.java              # Business logic
│   │           ├── repository/
│   │           │   └── CityRepository.java           # Data access layer
│   │           └── dto/
│   │               ├── CityDto.java                  # City data transfer object
│   │               ├── SatelliteDto.java             # Satellite data transfer object
│   │               └── IntersectionDto.java          # Intersection data transfer object
│   └── resources/
│       └── application.properties                    # Application configuration
└── test/
    └── java/
        └── org/
            └── satellitetocity/
                └── SatelliteToCItyApplicationTests.java
```

## Data Models

### CityDto
- `id` (Long) - Unique identifier
- `name` (String) - City name
- `latitudeDeg` (double) - Latitude in degrees
- `longitudeDeg` (double) - Longitude in degrees

### SatelliteDto
- `altitudeMeters` (double) - Altitude in meters
- `inclinationDeg` (double) - Orbital inclination in degrees
- `latitudeDeg` (double) - Current latitude in degrees
- `longitudeDeg` (double) - Current longitude in degrees
- `time` (Instant) - Timestamp of the position

### IntersectionDto
- `city` (CityDto) - The city involved in the intersection
- `firstVisibleTime` (Instant) - When the satellite first becomes visible
- `minDistanceKm` (double) - Minimum distance in kilometers

## Configuration

The application uses `application.properties` for configuration. Currently configured:

- `spring.application.name=SatelliteToCIty`

## Future Enhancements

- Add more REST endpoints (list all cities, add city, update city, delete city)
- Implement satellite intersection calculation logic
- Add database persistence (replace in-memory storage)
- Add proper exception handling with custom exceptions
- Add API documentation with Swagger/OpenAPI
- Add comprehensive unit and integration tests
- Add input validation
- Add logging

## Contributing

Contributions are welcome! Please feel free to submit a Pull Request.

## License

This project is open source and available under the MIT License.

