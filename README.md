# Character Creator API

This API lets you create a character for tabletop RPGs, loosely based on D&D 5e
and Pillars of Eternity. The API was developed with:
* Java 17
* Spring
* Docker Compose
* MongoDB

## Features

### Dice Rolls feature

- You can roll a D3, D4, D6, D10, D12, D20, and D100 dices.

### User feature

- Create new user, with username, email, and password.
- Retrieve user data.
- Allow users to change their username.
- Allow users to change their password.
- Allow users to delete their account.

### Player feature

- Allow a user to create a new player character.
- Allow a user to retrieve their player characters data.
- Allow a user to retrieve one of their player characters data.
- Allow a user to update their player character.
- Allow a user to delete their player character.

## How to execute the application
To set up the database, run:

```
docker-compose up -d --build
```

You need to create a keyspace with the name *pet_management_api* in the Cassandra database, after the containers are running.

Download the project dependencies with the following command:

```
mvn clean install
```

Execute the following command to run the application:

```
mvn spring-boot:run
```

Execute the application tests with the following command:

```
mvn test
```

## Author

Vitor Vidal - vitorvidal.dev@gmail.com

## License

This project uses the MIT License. You can read it [here].

[here]: https://github.com/vitorvidaldev/Character-Creator-API/blob/main/LICENSE