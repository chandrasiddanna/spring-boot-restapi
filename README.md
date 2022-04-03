# SpringBoot

This is a simple REST API in spring boot that accepts a list of Names and Postcodes in the HTTP request body, and persists the data in a database (either in memory or a traditional one). 

The API should also has an endpoint that receives a postcode range and returns in the response body the list of names belonging to that postcode range, sorted alphabetically as well as the total number of characters of all names combined. 

I have used Spring Boot, Lombok, JPA Repository, MYSQl DB and Junit.

Running the project from root directory:

mvn clean install
mvn spring-boot:run

End point - http://localhost:8080/api/suburbs

To save multiple suburbs (via postman)  - http://localhost:8080/api/suburbs/all

    POST Request:
    {
        "suburbs": [
            {
                "suburbName": "Darlington",
                "suburbPostcode": 6008
            },
            {
                "suburbName": "Test2",
                "suburbPostcode": 6014	
            },
            {
                "suburbName": "Test3",
                "suburbPostcode": 6016	
            },
            {
                "suburbName": "Aveley",
                "suburbPostcode": 6018
            }
        ]
    }

End point which receives post code range and returns list of suburb names belonging to the range in alphabetically sorted order as well as the total number of characters combined is 
- http://localhost:8080/api/suburbs/postcode?suburbPostcode1=6008&suburbPostcode2=6018

    GET Response:
    [
        "Aveley",
        "Darlington",
        "Test2",
        "Test3"
    ]