# Coding Challenge
## Description
This challenge consists of three services: Subscription service, Email service and Event service.

An anonymous user can consume the Subscription service by creating subscriptions to events that are identified by a newsletterId. These subscriptions also need a valid e-mail and some other data.

The Event and Email service are private, the calls to the API must be signed to assure they come from a trusted source. The Event service allows the user to retrieve some events by their newsletterId.

The Email service can send e-mails given an specific event, that is, this service searches for subscriptions related to the event and mails the users who are subscribed to that event.

## Usage
* Download the repository in any folder of your choice with Git:

`git clone https://github.com/adambarreiro/subscription-service.git`

* Build the application with Gradle:

`gradle build`

* Execute the Spring Boot embedded server with the application:

```
cd build/libs
java -jar subscriptions-api-0.1.0-SNAPSHOT.jar
```

## API specification

* `POST /subscription`
 
```
{
  newsletterId: Number,
  email: String,
  dateOfBirth: String(YYYY-MM-DD),
  consent: Boolean,
  firstName: String(Optional),
  gender: String(Optional)
}
```

* `POST /email`
```
{
  email: String
}
```

* `GET /event/{newsletterId}`

`newsletterId: Number`

## Tech stack

* **Gradle**: Modern build tool. Unlike others like Maven, Gradle is more flexible as it allows custom scripts as well as a wide variety of plugins. It's ALM is not such "Convention over Configuration" as Maven.
* **H2**: It's an in-memory database for testing purposes. Here is used to make a stub of the real database used by the services.
* **Java Mail**: Library for sending mails.
* **Spring Boot**: Framework for developing and deploying services fast and with a light and concise configuration.
* **Spring Data**: Framework for developing database access and data consumption with ease and with a light configuration.
* **Spring Security**: Framework to make the services secure, supporting a wide variety of authentication paradigms such web tokens, cookies, etc. It also provides a full common-attack prevention, such as CSRF attacks or CORS.

## TODO
* Security of the private API endpoints [[1]](http://docs.aws.amazon.com/AmazonS3/latest/dev/RESTAuthentication.html), [[2]](http://massimilianosciacco.com/implementing-hmac-authentication-rest-api-spring-security)
* Data input validation for the REST Controllers (mail, date, etc)
* Move the validation to appropiate filters/collaborators.
* Send real emails with a server (now it's a stub)
* Refactor the three services to be independent (3 deployable jars).
* Exception and error handling.

## FIXME
* Loading context error when starting Spring Boot test due to JPA repositories not finding the EntityManager bean.

## References
* [Spring Boot Reference](https://docs.spring.io/spring-boot/docs/current-SNAPSHOT/reference/htmlsingle/)
