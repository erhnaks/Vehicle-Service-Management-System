# QA 22MayEnable2 Software Core - Practical Project Vehicle Service Management System (VSMS)



## Contents:
* [Project Brief](#Project-Brief)  
* [Getting Started](#Getting-Started)
* [Prerequisites](#Prerequisites)  
* [Installing](#Installing)
* [MySQL Database](#MySQL-Database)
* [Project Management](#Project-Management)
* [Tests](#Tests)
* [SonarQube](#SonarQube)
* [Deployment](#Deployment)
* [Front End Visual](#Front-End-Visual)
* [Built With](#Built-With)
* [Versioning](#Versioning)
* [Authors](#Authors)
* [License](#License)
* [Acknowledgements](#Acknowledgements)



# Project Brief
## Vehicle Service Management System (VSMS)
![VSMS-Logo](https://user-images.githubusercontent.com/97620234/180649345-c0712a4f-d7d8-4968-a14d-cb297f7167cb.png)

Vehicle Service Management System is written in Java. OOP-Based web-application. This codebase was created to demonstrate a full-stack application built with Spring boot + MySQL including full CRUD operations.

This project aimed to have a CRUD-based web application, with the utilisation of supporting tools, methodologies, and technologies, that encapsulates all fundamental and practical modules covered during my software specialism training with QA.

## Getting Started

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes. See deployment for notes on how to deploy the project on a live system.

Use this link to clone the project: [GitHub-Link-VSMS](git@github.com:erhnaks/Vehicle-Service-Management-System.git)

## Prerequisites


You will need the following software and tools to build and run this application;

* Java JDK (version 11.0 or higher)
* Apache Maven
* Git (version control
* MySQL (database)
* Eclipse IDE 

## Installing

1. Clone the repository from [GitHub-Link](git@github.com:erhnaks/Vehicle-Service-Management-System.git)
2. Run it in the command line with the following command;
```
java -jar 1.0-fat.jar
```

## MySQL Database

##### Application ERD

![ERD-Final](https://user-images.githubusercontent.com/97620234/179769923-2ca54991-282d-4eb0-8d6b-ef5c11480357.png)

##### Application UML

![VSMS-UML-Diagram](https://user-images.githubusercontent.com/97620234/179770969-0d88def3-7a1f-4cc9-8a3d-21be7af0569c.png)

## Project Management

Jira Kanban board and GitHub was used for project management including GitHub Smart commits.

![Jira](https://user-images.githubusercontent.com/97620234/179771343-0d934754-21ee-45d3-8945-165b507929b8.png)

## Tests

### Test Coverage 

##### 97.8%

![Test-Coverage](https://user-images.githubusercontent.com/97620234/179840696-b04938b7-cb13-4be0-9eb7-24d6b187cfe9.png)

### Running the tests

To run the test for the application please clone the repository to your local machine by the link given below;
```
git@github.com:erhnaks/Vehicle-Service-Management-System.git
```
Once the cloning progress is completed, open your command line interface in the project folder and run the following command to initiate the test;

```
mvn test
```

### Unit Tests 

These tests are written to test the functions of the application and its methods.

### Unit Integration Test Example

```
@Test
	void testReadByAll() throws Exception {

		List<Vehicle> readVehicles = new ArrayList<>();
		readVehicles.add(new Vehicle(1, "LT68KUD", 1000, "Serviced", 99.00));
		String createdVehicleAsJSON = this.mapper.writeValueAsString(readVehicles);

		this.mvc.perform(get("/getAll")).andExpect(content().json(createdVehicleAsJSON)).andExpect(status().isOk());

	}

	@Test
	void testReadById() throws Exception {

		Vehicle readVehicle = new Vehicle(1, "LT68KUD", 1000, "Serviced", 99.00);
		String createdVehicleAsJSON = this.mapper.writeValueAsString(readVehicle);

		this.mvc.perform(get("/readById/1")).andExpect(content().json(createdVehicleAsJSON)).andExpect(status().isOk());
```

## SonarQube
##### Initial SonarQube Report

![Sonarqube-initial-before-fix](https://user-images.githubusercontent.com/97620234/179843150-fc1a2786-bbd2-4cec-a7ff-7ccd5dad2a7f.png)

##### Final (After-Fix) SonarQube Report

![Sonarqube-after-fixes](https://user-images.githubusercontent.com/97620234/179843285-e13d64f1-f0a3-4ad2-8a10-ffe982172b61.png)

## Deployment

Maven Deployment Tool has been used to deploy this application.

## Front End Visual
##### Front web page

![VSMS-front-page](https://user-images.githubusercontent.com/97620234/181634943-451010a7-09f4-484b-aa0e-ccacf192c724.png)

##### Creating new service report for the companies vehicle

![VSMS-Create](https://user-images.githubusercontent.com/97620234/179775740-46d030d3-5a25-43e2-8ede-719a0ea229f5.png)

##### Updating an existing service entry

![VSMS-update](https://user-images.githubusercontent.com/97620234/179775856-9b388348-0c3d-4883-ad02-b5d29f3c81a2.png)

## Built With

* [Maven](https://maven.apache.org/) - Dependency Management

## Versioning

GitHub Version Control [GitHub](http://github.com) for versioning.

## Authors

* **Erhan Aksu** [erhnaks](git@github.com:erhnaks/Vehicle-Service-Management-System.git)

## License

This project is licensed under the MIT license - see the [LICENSE.md](LICENSE.md) file for details 

*For help in [Choosing a license](https://choosealicense.com/)*

## Acknowledgements

* Special thanks to QA, Jordan Harrison and Jordan Benbelaid.
