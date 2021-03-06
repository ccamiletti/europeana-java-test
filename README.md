# Europeana-java-Test

## Requirements
For building and running the application you need:

- [JDK 1.8](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html)
- [Maven 3](https://maven.apache.org)

# Build Project

	mvn package

# REST API

This is a example of a Spring-Boot application providing a REST API.

## Run the app

    mvn spring-boot:run

## Run the tests

    mvn test

# EndPoints

The REST API to the europeana app is described below.

## Set upperNumber service (value between 1 and 25)

### Request

`POST /service/upperNumber/set?upperNumber=25`

    curl -i -H 'Accept: application/json' http://localhost:8080/service/upperNumber/set?upperNumber=25

### Response

    Request URL: http://localhost:8080/service/upperNumber/set?upperNumber=25
    Request Method: POST
    Status Code: 200 
    Remote Address: [::1]:8080
    

## Get Least Common Multiple
### Request

`GET /service/math/getLeastCommonMultiple`

    curl -i -H 'Accept: application/json' http://localhost:8080/service/math/getLeastCommonMultiple
    curl -i -H 'Accept: application/xml' http://localhost:8080/service/math/getLeastCommonMultiple

### Response

### Accept: application/json
	
    Request URL: http://localhost:8080/service/math/getLeastCommonMultiple
    Request Method: GET
    Status Code: 200
    Remote Address: [::1]:8080
    
	{
	    "leastCommonMultiple": 2520,
	    "executionTime": 2
	}

### Accept: application/xml
	
    Request URL: http://localhost:8080/service/math/getLeastCommonMultiple
    Request Method: GET
    Status Code: 200
    Remote Address: [::1]:8080
    
	<LeastCommonMultipleDTO>
	    <leastCommonMultiple>2520</leastCommonMultiple>
	    <executionTime>2</executionTime>
	</LeastCommonMultipleDTO>

