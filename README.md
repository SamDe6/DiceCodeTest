# Dice Code Test
Springboot application that once per second fetches a dice number from https://www.random.org/integers/?num=1&min=1&max=6&col=1&base=10&format=plain&rnd=new and stores the value in an H2 database table. Furthermore, there is a REST API that when called returns how many occurrences of each value have been stored in the database table e.g. if the table contains [4,1,3,1,4,4], output { "1": 2, "3": 1, "4": 3 }.

## Local URL
http://localhost:8080/fetchDiceCount

## Swagger URL
http://localhost:8080/swagger-ui.html

## External Dependencies
### REST endpoint for getting random dice number
https://www.random.org/integers/?num=1&min=1&max=6&col=1&base=10&format=plain&rnd=new

### Technologies
* Java 9
* Maven
* Junit 4
* Spring Boot
* Spring Data JPA
