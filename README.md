# url-shortener

1. Create a new Spring Boot app with the following dependencies
* Web starter
* Data JPA starter
* PostgreSQL Driver
* Flyway
* Lombok

2. Build a URL Shortener API
* Implement shorten URL endpoint (accepts a long URL and returns a short one)
Handle POST request by path .../short
Request body example
{
  "url": "https://github.com/bobocode-projects/java-fundamentals-exercises/tree/main/3-0-java-core/3-6-4-random-field-comparator",
  "title": "Random Field Comparator Exercise"
}
Shorten URL
Respond with status code CREATED and a header Location containing a shortened URL
* Implement redirect URL endpoint (handles request by short URL and redirects to to the original URL) :arrows_counterclockwise:
Handle GET request by path .../short/{shortenUrlId} e.g. ../short/xc4RR32s
Find original URL by id
Redirect current request to the original URL

3. Build a Service Layer
Implement shortener logic
Generate a unique identifier for provided URL
Create ShortenedUrl object
Save original URL
Implement a logic that allows to get original URL by id

4. Build a Persistence Layer
* Add a Flyway migration script to create a database table
shortened_urls
id
original_url
title
created_at
* Create corresponding JPA entities with proper mapping ShortenedUrl
* Implement a required data access logic using Spring Data JPA
