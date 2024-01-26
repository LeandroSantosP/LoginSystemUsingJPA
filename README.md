# Authentication API

![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=white)
![Spring](https://img.shields.io/badge/spring-%236DB33F.svg?style=for-the-badge&logo=spring&logoColor=white)
![Postgres](https://img.shields.io/badge/postgres-%23316192.svg?style=for-the-badge&logo=postgresql&logoColor=white)
![JWT](https://img.shields.io/badge/JWT-black?style=for-the-badge&logo=JSON%20web%20tokens)

This project is an API built using **Java, Java Spring, jpa, PostgresSQL as the database, and Spring Security and JWT for authentication control.**

The API was development by me to understand how to configure Authentication and Authorization in Spring application using Spring Security.

## Table of Contents

- [Installation](#installation)
- [Configuration](#configuration)
- [Usage](#usage)
- [API Endpoints](#api-endpoints)
- [Authentication](#authentication)
- [Database](#database)
- [Contributing](#contributing)

## Installation

1. Clone the repository:

```bash
git clone https://github.com/LeandroSantosP/LoginSystemUsingJPA.git
```

2. Install dependencies with Maven

3. Install [PostgresSQL](https://www.postgresql.org/) # docker recommend

## Configuration

Create an application.properties file in resources folder with your postgres credentials, and enter a secret for jwt as shown in follow example:

spring.datasource.url="YOUR_DATABASE_URL"
spring.datasource.username="YOUR_USER_NAME"
spring.datasource.password="YOUR_PASSWORD"

api.security.jwt_secret=

Check applicationExample.properties file.

## Usage

1. Start the application with Maven
2. The API will be accessible at http://localhost:8080

## API Endpoints

The API provides the following endpoints:

```markdown
GET /get/${USER_ID} - Get the user info. (all authenticated users)

POST /login - Login into the App

POST /create - Create a new user into the App
```

## Authentication

The API uses Spring Security for authentication control. The following roles are available:

```
USER -> Standard user role for logged-in users.
ADMIN -> Admin role for managing specific rotes.
```

To access protected endpoints as an ADMIN user, provide the appropriate authentication credentials in the request header.

## Database

The project utilizes [PostgresSQL](https://www.postgresql.org/) as the database. The necessary database migrations are managed using Flyway.

## Contributing

Contributions are welcome! If you find any issues or have suggestions for improvements, please open an issue or submit a pull request to the repository.

When contributing to this project, please follow the existing code style, [commit conventions](https://www.conventionalcommits.org/en/v1.0.0/), and submit your changes in a separate branch.
