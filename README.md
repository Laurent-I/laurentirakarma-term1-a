
```markdown
# Getting Started

This project is a simple calculator API built with Java and Spring Boot.

## Prerequisites

Before you begin, ensure you have met the following requirements:

* You have installed Java 11 or later.
* You have installed Maven.
* You have a basic understanding of Java and Spring Boot.

## Cloning the Project

To clone the project, follow these steps:

1. Open a terminal.
2. Run the following command to clone the project:

```bash
git clone https://github.com/Laurent-I/laurentirakarama-term1-a.git
```

Replace `your-username` and `your-project-name` with your GitHub username and the name of your project.

## Setting Up the Project

After cloning the project, you need to import it into your IDE. If you're using IntelliJ IDEA, follow these steps:

1. Open IntelliJ IDEA.
2. Click on `File > Open`.
3. Navigate to the directory where you cloned the project and click `OK`.
4. IntelliJ IDEA will automatically detect the Maven project and import it.

## Running the Project

To run the project, follow these steps:

1. Open a terminal.
2. Navigate to the root directory of your project where the `pom.xml` file is located.
3. Run the following command:

```bash
mvn spring-boot:run
```

This command will start your application. Once the application is started, you can access the `doMath` API endpoint at `http://localhost:8080/doMath` with a POST request.

## Testing the Project

To run the tests in the project, follow these steps:

1. Open a terminal.
2. Navigate to the root directory of your project where the `pom.xml` file is located.
3. Run the following command:

```bash
mvn test
```

This command will run all the tests in your project.

## Reference Documentation

For further reference, please consider the following sections:

* [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)
* [Spring Boot Maven Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/3.2.0/maven-plugin/reference/html/)
* [Create an OCI image](https://docs.spring.io/spring-boot/docs/3.2.0/maven-plugin/reference/html/#build-image)
* [Spring REST Docs](https://docs.spring.io/spring-restdocs/docs/current/reference/html5/)
* [Spring Web](https://docs.spring.io/spring-boot/docs/3.2.0/reference/htmlsingle/index.html#web)
* [Spring Boot DevTools](https://docs.spring.io/spring-boot/docs/3.2.0/reference/htmlsingle/index.html#using.devtools)

## Guides

The following guides illustrate how to use some features concretely:

* [Building a RESTful Web Service](https://spring.io/guides/gs/rest-service/)
* [Serving Web Content with Spring MVC](https://spring.io/guides/gs/serving-web-content/)
* [Building REST services with Spring](https://spring.io/guides/tutorials/rest/)
```