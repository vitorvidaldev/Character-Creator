# Character Creator API

Character Creator API for tabletop RPGs.

## API Description
This API lets you create a character for tabletop RPGs, loosely based on D&D 5e and Pillars of Eternity.

The following diagram describes the relationships designed for this application.

![Project Design](./docs/character_creator_api.drawio.svg)

## Application requirements
* Maven 3.8.1
* Java 11
* Spring Boot 2.5
* Docker
* Docker Compose

## How to execute the application
Instantiate the database using the following command:
```
docker-compose up -d --build
```

Run the application using IntelliJ. You can access the application via `localhost:8080`.

## Postman Collection
TODO

## Author
Vitor Vidal - vitorvidal.dev@gmail.com

## License
This project uses the MIT License. You can read it [here].

[here]: https://github.com/vitorvidaldev/Character-Creator-API/blob/main/LICENSE