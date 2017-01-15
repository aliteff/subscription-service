# Coding Challenge
## Description
This challenge consists of three services: Subscription service, Email service and Event service.

An anonymous user can consume the Subscription service by creating subscriptions to events that are identified by a newsletterId. These subscriptions also need a valid e-mail and some other data.

The Event and Email service are private, the user must be authenticated in order to use them. The Event service allows the user to retrieve some events by their newsletterId.

The Email service can send e-mails given an specific event, that is, this service searches for subscriptions related to the event and mails the users who are subscribed to that event.

## Usage
* Download the repository in any folder of your choice with Git:

`git clone https://github.com/adambarreiro/subscription-service.git`

* Build the application with Gradle:

`gradle build`

* Execute the Spring Boot embedded server with the application:

`java -jar build/lib/subscriptions-api-0.1.0-SNAPSHOT.jar`

## API specification

* `PUT /subscription`

JSON: `{ newsletterId: Number, email: String, dateOfBirth: String(YYYY-MM-DD), consent: Boolean, firstName: String(Optional), gender: String(Optional) }`

* `POST /email`

JSON: `{email: String }`

* `GET /event`

JSON: `{newsletterId: Number }`

## Tech stack

* Gradle: Modern build tool. Unlike others like Maven, Gradle is more flexible as it allows custom scripts as well as a wide variety of plugins. It's ALM is not such "Convention over Configuration" as Maven.
* H2: It's an in-memory database for testing purposes. Here is used to make a stub of the real database used by the services.
* Java Mail: Library for sending mails.
* Spring Boot: Framework for developing and deploying services fast and with a light and concise configuration.
* Spring Data: Framework for developing database access and data consumption with ease and with a light configuration.
* Spring Security: Framework to make the services secure, supporting a wide variety of authentication paradigms such web tokens, cookies, etc. It also provides a full common-attack prevention, such as CSRF attacks or CORS.

## References
* [Spring Boot Reference](https://docs.spring.io/spring-boot/docs/current-SNAPSHOT/reference/htmlsingle/)
* [Securing Spring Boot APIs](https://www.future-processing.pl/blog/exploring-spring-boot-and-spring-security-custom-token-based-authentication-of-rest-services-with-spring-security-and-pinch-of-spring-java-configuration-and-spring-integration-testing/)

