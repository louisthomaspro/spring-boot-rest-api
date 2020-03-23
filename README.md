# Spring Boot REST Tutorial

## Environment

- [Oracle JDK 1.8+](https://www.oracle.com/java/technologies/javase-downloads.html)
- [Maven 3.2+](https://maven.apache.org/download.cgi) (used for projects build, dependency and documentation)
- [Eclipse IDE](https://www.eclipse.org/downloads/) or [VScode](https://code.visualstudio.com/download)
- [Spring Tools plugin](https://spring.io/tools) (set of tools)
- [Docker](https://docs.docker.com/install/) and [docker-compose](https://docs.docker.com/compose/install/)


## Installation

**Clone projet**

1. Clone

```bash=
git clone https://github.com/louisthomaspro/spring-boot-rest-api.git
```

2. Run postgre database with docker

```bash=
docker-compose up -d --build
```

3. Run application

```bash=
mvn spring-boot:run
```

Navigate to http://localhost:8080/