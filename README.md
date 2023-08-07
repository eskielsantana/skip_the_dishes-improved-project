## SkipTheDishes - Interview Challenge - Improved Project

## About

This is an improved version of the [SkipTheDishes Interview project](https://github.com/eskielsantana/skip_the_dishes-project) I created back in **2018** as an applicant for **the Software Engineer** role. 

The reason I created a second project for it is that I wanted to add some extra but I decided to keep the **original project untouched** since it was tested and would be analyzed by the company

## Goal

- Create a microservice application containing an API for the following requests:

  - Receive a request with new customer data and register it on a database
  
  - Receive a customer request to log in and return its access token in case the given password matches the registered
  
  - Receive a request to return a registered order by the given id
  
  - Receive a request to return all the registered orders
  
  - Receive a request to register a new order
  
  - Receive a request to cancel an already existent order
  
  - Receive a request to return the status of the order by the given id
  
- All the order-related requests must receive a token used to authenticate if the user is allowed to execute the related action.

- The customer login request has a simple but efficient password encryption/encryption system so its password will not be stored in a raw format


## Stack for this Project

- Java - SpringBoot Framework (MVC Architecture)

- MySql + JPA - Database and data persist

- Swagger - Used for agile endpoint documentation and test

- Kafka - Submit a message to registered consumers about the creation/cancelation of a new order

## Install

### Download the repository

  $ git clone https://github.com/eskielsantana/skip_the_dishes-improved-project.git

### Generate the jar file

  $ cd skip_the_dishes-improved-project && mvn clean install

### Run the application (Windows or MacOS)

  $ java -jar SkipTheDishesChallenge-0.0.1-SNAPSHOT.jar
  
## Author

- Ezequiel Sant'Ana Junior - [LinkedIn](https://www.linkedin.com/in/ezequiel-santana/)

## Author Note

This is a project from **2018** and since I am not maintaining it since that year it might have dependencies issues nowadays and the build might fail but still a good content for study
