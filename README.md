# Character Creator API

Character Creator API for tabletop RPGs.

## API Description
This API lets you create a character for tabletop RPGs, loosely based on D&D 5e and Pillars of Eternity.

## Application requirements
* Maven 3.8.1
* Java 11
* Spring Boot 2.5.3
* Docker
* Docker Compose

## How to execute the application
To execute the docker-compose.yaml file, run:
```
./mvnw package

docker-compose up -d --build
```

You can access the application via `localhost:8080`.

You can access Kibana at `http://localhost:5601/app/management/kibana/indexPatterns`.

## Postman Collection
TODO

## Author
Vitor Vidal - vitorvidal.dev@gmail.com

## License
This project uses the MIT License. You can read it [here].

[here]: https://github.com/vitorvidaldev/Character-Creator-API/blob/main/LICENSE