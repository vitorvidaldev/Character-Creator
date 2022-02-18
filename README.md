# Character Creator API

Character Creator API for tabletop RPGs.

## API Description
This API lets you create a character for tabletop RPGs, loosely based on D&D 5e and Pillars of Eternity.

The following diagram describes the relationships designed for this application.

![Project Design](./docs/character_creator_api.drawio.svg)

### Roll the dice feature

You can call a service to obtain a die roll. 

The dice available are:
* D3
* D4
* D6
* D8
* D10
* D12
* D20
* D100

## Application requirements
* Maven 3.8
* Java 17
* Spring Boot 2.6
* Docker
* Docker Compose

## How to execute the application
Instantiate the database using the following command:
```
docker-compose up -d --build
```

You can use MongoDB Compass to manage and visualize your data during tests.

Run the application using IntelliJ. You can access the application via `localhost:8080`, or via command line with `mvn spring-boot:run`

## Tests

Execute the tests running the following command (the command is slightly different in Windows and macOS).
```
mvn clean install && google-chrome target/site/jacoco/index.html
```

## Author
Vitor Vidal - vitorvidal.dev@gmail.com

## License
This project uses the MIT License. You can read it [here].

[here]: https://github.com/vitorvidaldev/Character-Creator-API/blob/main/LICENSE