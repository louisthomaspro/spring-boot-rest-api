# Spring Boot REST Tutorial

This project is implementing :
- Controllers
- Models
- ManyToOne relationship
- Custom Queries

## Environment

- [Oracle JDK 1.8+](https://www.oracle.com/java/technologies/javase-downloads.html)
- [Maven 3.2+](https://maven.apache.org/download.cgi) (used for projects build, dependency and documentation)
- [Eclipse IDE](https://www.eclipse.org/downloads/) or [VScode](https://code.visualstudio.com/download)
- [Spring Tools plugin](https://spring.io/tools) : set of tools for Spring Boot (optional)
- [Docker](https://docs.docker.com/install/) and [docker-compose](https://docs.docker.com/compose/install/)


## Installation

**Clone projet**

1. Clone

```bash=
git clone https://github.com/louisthomaspro/spring-boot-rest-api.git
cd spring-boot-rest-api
```

2. Run postgre database with docker

```bash=
docker-compose up -d --build
```

3. Run application

```bash=
mvn spring-boot:run
```

4. Get [Postman Collection](https://www.getpostman.com/collections/1d102f52352716987f2d)

## Build jar

```bash=
mvn clean package -Dmaven.test.skip=true
```

## Wiki

Find more on the [Wiki](https://github.com/louisthomaspro/spring-boot-rest-api/wiki)